package com.example.criandoapidozero.resource;

import com.example.criandoapidozero.entity.Address;
import com.example.criandoapidozero.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressResource {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAll() {

        return ResponseEntity.ok().body(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Address address) {
        address = addressService.save(address);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(address.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Address> mergeToUpdate(@RequestBody Address newAddress, @PathVariable Integer id) {
        Address address = addressService.findById(id);
        newAddress = addressService.mergeToUpdate(address, newAddress);

        return ResponseEntity.ok().body(addressService.save(newAddress));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package com.example.criandoapidozero.service;

import com.example.criandoapidozero.entity.Address;
import com.example.criandoapidozero.exception.BusinessException;
import com.example.criandoapidozero.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(() -> new BusinessException("Endereço não encontrado"));
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address mergeToUpdate(Address address, Address newAddress) {
        address.setStreet(newAddress.getStreet());
        address.setCep(newAddress.getCep());
        address.setStudents(newAddress.getStudents());

        return address;
    }

    public void delete(Integer id) {
        findById(id);
        addressRepository.deleteById(id);
    }
}

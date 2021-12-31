package com.example.criandoapidozero.resource;

import com.example.criandoapidozero.entity.Class;
import com.example.criandoapidozero.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("classes")
public class ClassResource {

    @Autowired
    private ClassService classService;

    @GetMapping
    public ResponseEntity<List<Class>> findAll() {

        return ResponseEntity.ok().body(classService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Class classe) {
        classe = classService.save(classe);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(classe.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Class> mergeToUpdate(@RequestBody Class newClasse, @PathVariable Integer id) {
        Class classe = classService.findById(id);
        newClasse = classService.mergeToUpdate(classe, newClasse);

        return ResponseEntity.ok().body(classService.save(newClasse));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        classService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

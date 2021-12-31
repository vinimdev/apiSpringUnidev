package com.example.criandoapidozero.resource;

import com.example.criandoapidozero.entity.Student;
import com.example.criandoapidozero.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {

        return ResponseEntity.ok().body(studentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Student student) {
        student = studentService.save(student);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(student.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> mergeToUpdate(@RequestBody Student newStudent, @PathVariable Integer id) {
        Student student = studentService.findById(id);
        newStudent = studentService.mergeToUpdate(student, newStudent);

        return ResponseEntity.ok().body(studentService.save(newStudent));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

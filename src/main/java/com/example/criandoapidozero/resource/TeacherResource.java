package com.example.criandoapidozero.resource;

import com.example.criandoapidozero.entity.Teacher;
import com.example.criandoapidozero.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherResource {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> findAll() {

        return ResponseEntity.ok().body(teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Teacher teacher) {
        teacher = teacherService.save(teacher);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(teacher.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Teacher> mergeToUpdate(@RequestBody Teacher newTeacher, @PathVariable Integer id) {
        Teacher teacher = teacherService.findById(id);
        newTeacher = teacherService.mergeToUpdate(teacher, newTeacher);

        return ResponseEntity.ok().body(teacherService.save(newTeacher));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

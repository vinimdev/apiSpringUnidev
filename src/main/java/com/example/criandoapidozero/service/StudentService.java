package com.example.criandoapidozero.service;

import com.example.criandoapidozero.entity.Student;
import com.example.criandoapidozero.exception.BusinessException;
import com.example.criandoapidozero.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(() -> new BusinessException("Estudante não encontrado"));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student mergeToUpdate(Student student, Student newStudent) {
        student.setName(newStudent.getName());
        student.setLastName(newStudent.getLastName());
        student.setCpf(newStudent.getCpf());
        student.setClasses(newStudent.getClasses());
        student.setAddress(newStudent.getAddress());
        student.setTelephones(newStudent.getTelephones());

        return student;
    }

    public void delete(Integer id) {
        findById(id);
        studentRepository.deleteById(id);
    }
}

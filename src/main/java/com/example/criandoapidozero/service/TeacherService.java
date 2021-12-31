package com.example.criandoapidozero.service;

import com.example.criandoapidozero.entity.Teacher;
import com.example.criandoapidozero.exception.BusinessException;
import com.example.criandoapidozero.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new BusinessException("Professor(a) não encontrado"));
    }

    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher mergeToUpdate(Teacher teacher, Teacher newTeacher) {
        teacher.setName(newTeacher.getName());
        teacher.setLastName(newTeacher.getLastName());
        teacher.setCpf(newTeacher.getCpf());
        teacher.setClasse(newTeacher.getClasse());

        return teacher;
    }

    public void delete(Integer id) {
        findById(id);
        teacherRepository.deleteById(id);
    }
}

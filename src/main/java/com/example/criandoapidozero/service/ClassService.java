package com.example.criandoapidozero.service;

import com.example.criandoapidozero.entity.Class;
import com.example.criandoapidozero.exception.BusinessException;
import com.example.criandoapidozero.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public Class findById(Integer id) {
        Optional<Class> classe = classRepository.findById(id);
        return classe.orElseThrow(() -> new BusinessException("Estudante não encontrado"));
    }

    public Class save(Class classe) {
        return classRepository.save(classe);
    }

    public Class mergeToUpdate(Class classe, Class newClasse) {
        classe.setTitle(newClasse.getTitle());
        classe.setTeacher(newClasse.getTeacher());
        classe.setStudents(newClasse.getStudents());

        return classe;
    }

    public void delete(Integer id) {
        findById(id);
        classRepository.deleteById(id);
    }
}

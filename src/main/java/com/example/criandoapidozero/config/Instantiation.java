package com.example.criandoapidozero.config;

import com.example.criandoapidozero.entity.Address;
import com.example.criandoapidozero.entity.Class;
import com.example.criandoapidozero.entity.Student;
import com.example.criandoapidozero.entity.Teacher;
import com.example.criandoapidozero.repository.AddressRepository;
import com.example.criandoapidozero.repository.ClassRepository;
import com.example.criandoapidozero.repository.StudentRepository;
import com.example.criandoapidozero.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class Instantiation implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TeacherRepository teacherRepository;



    @Override
    public void run(String... args) throws Exception {

//        Class algoritmo = new Class("Algoritmo");
//        Class estruturaDados = new Class("Estrutura de Dados");
//        Class poo = new Class("Programação Orientada a Objeto");
//
//        Teacher alex = new Teacher("Alex", "Paixão", "24252624224", algoritmo);
//        algoritmo.setTeacher(alex);
//
//        Teacher paulo = new Teacher("Paulo", "Reis", "32147865244", poo);
//        poo.setTeacher(paulo);
//
//        Teacher calhau = new Teacher("Flavio", "Calhau", "32145678954", estruturaDados);
//        estruturaDados.setTeacher(calhau);
//
//        Address luisTarquinio = new Address("Avenida Luis Tarquinio", "42702420");
//        Address diqueTororo = new Address("Dique do Tororó", "41200541");
//        Address estradaCoco = new Address("Estrada do Coco", "42700000");
//
//        Student einstein = new Student("Albert", "Einstein", "00011122233");
//        Student galileo = new Student("Galileo", "Galilei", "11122233344");
//        Student tesla = new Student("Nikola", "Tesla", "22233344455");
//
//        teacherRepository.saveAll(Arrays.asList(alex, paulo, calhau));
//        classRepository.saveAll(Arrays.asList(algoritmo, estruturaDados, poo));
//
//        addressRepository.saveAll(Arrays.asList(luisTarquinio, diqueTororo, estradaCoco));
//
//        luisTarquinio.setStudents(Arrays.asList(einstein, galileo));
//        estradaCoco.setStudents(Arrays.asList(tesla));
//
//        algoritmo.setStudents(Arrays.asList(einstein, tesla));
//        estruturaDados.setStudents(Arrays.asList(einstein, galileo));
//        poo.setStudents(Arrays.asList(tesla, galileo));
//
//        einstein.setClasses(Arrays.asList(algoritmo, estruturaDados, poo));
//        galileo.setClasses(Arrays.asList(estruturaDados, poo));
//        tesla.setClasses(Arrays.asList(poo, algoritmo));
//
//        einstein.setAddress(luisTarquinio);
//        galileo.setAddress(luisTarquinio);
//        tesla.setAddress(estradaCoco);
//
//        einstein.getTelephones().addAll(Arrays.asList("71999654102", "7199965742415"));
//        tesla.getTelephones().addAll(Arrays.asList("7133657485"));
//        galileo.getTelephones().addAll(Arrays.asList("7130214587", "71985471598"));
//
//        studentRepository.saveAll(Arrays.asList(einstein, galileo, tesla));


    }
}

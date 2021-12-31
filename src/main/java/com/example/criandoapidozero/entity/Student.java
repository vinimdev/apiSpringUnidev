package com.example.criandoapidozero.entity;

import com.example.criandoapidozero.core.entity.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Student extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String lastName;

    private String cpf;

    @ElementCollection
    @CollectionTable(name = "TELEPHONES")
    private Set<String> telephones = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "STUDENT_CLASS",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<Class> classes = new ArrayList<>();

    public Student(String name, String lastName, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
    }
}

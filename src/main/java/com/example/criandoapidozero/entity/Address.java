package com.example.criandoapidozero.entity;

import com.example.criandoapidozero.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Address extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String street;

    private String cep;

    @OneToMany(mappedBy = "address")
    private List<Student> students = new ArrayList<>();

    public Address(String street, String cep) {
        this.street = street;
        this.cep = cep;
    }

}

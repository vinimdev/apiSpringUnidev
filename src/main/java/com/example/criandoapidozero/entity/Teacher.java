package com.example.criandoapidozero.entity;

import com.example.criandoapidozero.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Teacher extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String lastName;

    private String cpf;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Class classe;
}

package com.example.criandoapidozero.entity;

import com.example.criandoapidozero.core.entity.AbstractEntity;
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
public class Class extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    @ManyToMany(mappedBy = "classes")
    private List<Student> students = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Class(String title) {
        this.title = title;
    }
}

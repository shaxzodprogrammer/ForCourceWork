package com.example.coursework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;

    private String last_name;

    @Column(length = 15)
    private String phone_number;

    private String speciality;

    @Column(length = 2)
    private int experience;

    @ManyToMany
    private Set<Course> courses;
}

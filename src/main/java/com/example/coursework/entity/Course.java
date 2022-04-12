package com.example.coursework.entity;

import com.example.coursework.entity.enums.CourceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,unique = true)
    private String subject;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CourceType type;

    @Column(length = 3)
    private int numsOfHours;

    private double fee;

    @ManyToMany
    private Set<Teacher> teacher;
}

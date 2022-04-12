package com.example.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private int numOfStudent;

    @Column(nullable = false)
    private String startsAt;

    @Column(nullable = false)
    private String endsAt;

    @Column(nullable = false)
    @ManyToMany
    private Set<Course> course;
}

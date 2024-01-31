package com.bree.springproject.quizapplicationproject.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;

    @ManyToMany
    private List<Question> questions;

    public void save(Quiz quiz) {

    }
}

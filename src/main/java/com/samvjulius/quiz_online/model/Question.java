package com.samvjulius.quiz_online.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String question;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String questionType;

    @NotEmpty
    @ElementCollection
    List<String> choices;

    @NotEmpty
    @ElementCollection
    List<String> correctAnswers;
}

package com.samvjulius.quiz_online.service;

import com.samvjulius.quiz_online.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestionById(Long Id);

    Lis

}

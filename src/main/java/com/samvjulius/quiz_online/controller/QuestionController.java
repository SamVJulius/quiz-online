package com.samvjulius.quiz_online.controller;

import com.samvjulius.quiz_online.model.Question;
import com.samvjulius.quiz_online.service.QuestionServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
public class QuestionController {

    private final QuestionServiceInterface questionService;

    @PostMapping("/create-new-question")
    public ResponseEntity<Question> createNewQuestion(@Valid @RequestBody Question question)
    {
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(CREATED).body(createdQuestion);
    }

    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Question> requiredQuestion = questionService.getQuestionById(id);
        if(requiredQuestion.isPresent())
        {
            return ResponseEntity.ok(requiredQuestion.get());
        }
        else
        {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id)
    {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/subjects")
    public ResponseEntity<List<String>> getAllSubjects()
    {
        List<String> allSubjects = questionService.getAllSubjects();
        return ResponseEntity.ok(allSubjects);
    }

    @GetMapping("/fetch-questions-for-user")
    public ResponseEntity<List<Question>> getQuestionsForUser(@RequestParam int numOfQuestions,
                                                              @RequestParam String subject)
    {
        List<Question> allQuestions = questionService.getQuestionsForUser(numOfQuestions, subject);
        List<Question> mutableList = new ArrayList<>(allQuestions);
        Collections.shuffle(mutableList);
        int availableQuestions = Math.min(numOfQuestions, mutableList.size());
        List<Question> randomQuestions = mutableList.subList(0, availableQuestions);
        return ResponseEntity.ok(randomQuestions);
    }
}

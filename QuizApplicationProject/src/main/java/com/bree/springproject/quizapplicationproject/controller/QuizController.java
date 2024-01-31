package com.bree.springproject.quizapplicationproject.controller;

import com.bree.springproject.quizapplicationproject.model.Question;
import com.bree.springproject.quizapplicationproject.model.QuizWrapper;
import com.bree.springproject.quizapplicationproject.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
    return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(@PathVariable Long id ){
        return quizService.getQuizQuestions(id);
    }
}

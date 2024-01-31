package com.bree.springproject.quizapplicationproject.controller;

import com.bree.springproject.quizapplicationproject.model.Question;
import com.bree.springproject.quizapplicationproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){
        return questionService. getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
       return new ResponseEntity<>(questionService.addQuestion(question).getStatusCode());
    }

}


package com.bree.springproject.quizapplicationproject.service;

import com.bree.springproject.quizapplicationproject.DAO.QuestionDAO;
import com.bree.springproject.quizapplicationproject.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
       return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        return "Question successfully added";
    }
}



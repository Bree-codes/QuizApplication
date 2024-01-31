package com.bree.springproject.quizapplicationproject.service;

import com.bree.springproject.quizapplicationproject.DAO.QuestionDAO;
import com.bree.springproject.quizapplicationproject.DAO.QuizDAO;
import com.bree.springproject.quizapplicationproject.model.Question;
import com.bree.springproject.quizapplicationproject.model.Quiz;
import com.bree.springproject.quizapplicationproject.model.QuizWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDAO.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setId(quiz.getId());
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quiz.save(quiz);

        return new ResponseEntity<>("success" , HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuizWrapper>> getQuizQuestions(Long id) {
      Optional<Quiz> quiz = quizDAO.findById(id);
      List<Question> questionsFromDB = quiz.get().getQuestions();
      List<QuizWrapper> questionsForUser = new ArrayList<>();
      for(Question q : questionsFromDB){
          QuizWrapper qw = new QuizWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(), q.getOption3(), q.getOption4());
          questionsForUser.add(qw);
      }

      return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
}

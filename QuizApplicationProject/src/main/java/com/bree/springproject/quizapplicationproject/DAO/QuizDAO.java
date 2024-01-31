package com.bree.springproject.quizapplicationproject.DAO;

import com.bree.springproject.quizapplicationproject.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz,Long> {

}

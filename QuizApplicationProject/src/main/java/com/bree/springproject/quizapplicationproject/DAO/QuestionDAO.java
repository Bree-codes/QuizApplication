package com.bree.springproject.quizapplicationproject.DAO;

import com.bree.springproject.quizapplicationproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Long> {
    List<Question> findByCategory(String category);
}


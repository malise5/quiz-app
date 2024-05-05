package com.malise.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malise.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

    
}
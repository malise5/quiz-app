package com.malise.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.malise.quizapp.model.Question;
import com.malise.quizapp.model.QuestionWrapper;
import com.malise.quizapp.service.QuizService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQuiz, @RequestParam String title) {
        
        // return new ResponseEntity<>("I am here", HttpStatus.CREATED);
        return quizService.createQuiz(category, numQuiz, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id) {
        return quizService.getQuizQuestion(id);
    }
    
    
    
}

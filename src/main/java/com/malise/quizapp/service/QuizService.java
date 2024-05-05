package com.malise.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.malise.quizapp.model.Question;
import com.malise.quizapp.model.QuestionWrapper;
import com.malise.quizapp.model.Quiz;
import com.malise.quizapp.repository.QuestionDao;
import com.malise.quizapp.repository.QuizDao;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQuiz, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQuiz);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return new ResponseEntity<>("created successfully", HttpStatus.CREATED);
        
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questionsFromDB = quiz.get().getQuestions();

        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for ( Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(), q.getDifficultlevel(), q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(), q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    
    }
}

package com.jaydot2.webquiz23.server.model;

import java.util.List;

/**
 * Created by jamesbray on 8/31/16.
 */
public class Quiz {

    public static final String QUIZ_ID = "quizId";
    public static final String QUIZ_NAME = "quizName";
    private double id = -1;
    private String quizname = "";
    private List<Question> questions;

    /**
     * Default constructor
     */
    public Quiz() {
        // default constructor
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getQuizname() {
        return quizname;
    }

    public void setQuizname(String quizname) {
        this.quizname = quizname;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

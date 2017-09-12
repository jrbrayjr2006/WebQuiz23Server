package com.jaydot2.webquiz23.server.model;

import java.util.List;
import java.util.Map;

/**
 * Created by jamesbray on 8/31/16.
 */
public class Question {

    private double id = -1;
    private String questionText = "";
    private List<Map<String,String>> options;
    private String answerKey = "";
    private String explanation = "";

    /**
     * Default constructor
     */
    public Question() {
        // default constructor
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Map<String, String>> getOptiopns() {
        return options;
    }

    public void setOptiopns(List<Map<String, String>> options) {
        this.options = options;
    }

    public String getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(String answerKey) {
        this.answerKey = answerKey;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}

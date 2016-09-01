package com.jaydot2.webquiz23.server.delegate;

import com.jaydot2.webquiz23.server.model.Quiz;

/**
 * Created by jamesbray on 8/31/16.
 */
public interface DAO {

    public double quizCount();

    public boolean createQuiz(Quiz quiz);
}

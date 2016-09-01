package com.jaydot2.webquiz23.server.delegate;

import com.jaydot2.webquiz23.server.dao.DAOMongoDBImpl;
import com.jaydot2.webquiz23.server.model.Quiz;

/**
 * Created by jamesbray on 8/31/16.
 */
public class DataDelegate implements DAO {

    private DAO daoImpl = DAOMongoDBImpl.getInstance();

    @Override
    public double quizCount() {
        double result = daoImpl.quizCount();
        return result;
    }

    @Override
    public boolean createQuiz(Quiz quiz) {
        boolean result = daoImpl.createQuiz(quiz);
        return result;
    }
}

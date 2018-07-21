package com.jaydot2.webquiz23.server.dao;

import com.jaydot2.webquiz23.server.delegate.DAO;
import com.jaydot2.webquiz23.server.model.Quiz;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.bson.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by jamesbray on 8/30/16.
 */
public class DAOMongoDBImpl implements DAO {

    private static final String TAG = "DAOMongoDBImpl";
    private static Logger LOG = LoggerFactory.getLogger(DAOMongoDBImpl.class);

    private MongoClient mongoClient;
    private String host = "localhost";
    private int port = 27017;

    private DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    private static DAOMongoDBImpl dao;

    private DAOMongoDBImpl() {}

    public static DAOMongoDBImpl getInstance() {
        if(dao == null) {
            dao = new DAOMongoDBImpl();
        }
        return dao;
    }

    /**
     * <b>Description:</b>
     * <p>
     *     Set up a reusable connection to the document database
     * </p>
     * @param server
     * @param port
     */
    public void setDatabaseConnection(String server, int port) {
        LOG.debug(TAG + " ::ENTER:: setDatabaseConnection(String,int)...");
        if(mongoClient == null) {
            mongoClient = new MongoClient(server,port);
        }
        LOG.debug(TAG + " ::EXIT:: setDatabaseConnection(String,int)...");
    }

    //@Override
    public double quizCount() {
        LOG.debug(TAG + "::ENTER::");
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }
        MongoDatabase db = mongoClient.getDatabase("quizdb");
        MongoCollection<Document> quizCollection = db.getCollection("quiz");
        double count = quizCollection.count();
        return count;
    }

    //@Override
    public boolean createQuiz(Quiz quiz) {
        LOG.debug(TAG + "::ENTER::createQuiz(Quiz)...");
        if(mongoClient == null) {
            setDatabaseConnection(host,port);
        }
        MongoDatabase db = mongoClient.getDatabase("quizdb");
        MongoCollection<Document> quizCollection = db.getCollection("quiz");
        double index = quizCollection.count() + 1;
        quiz.setId(index);

        Document quizdoc = new Document(Quiz.QUIZ_ID,quiz.getId()).append(Quiz.QUIZ_NAME,quiz.getQuizname());
        boolean result = false;
        quizCollection.insertOne(quizdoc);
        result = true;
        LOG.debug(TAG + "::EXIT::createQuiz(Quiz)...");
        return result;
    }
}

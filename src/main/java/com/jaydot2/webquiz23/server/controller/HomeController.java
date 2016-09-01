package com.jaydot2.webquiz23.server.controller;

import com.jaydot2.webquiz23.server.delegate.DataDelegate;
import com.jaydot2.webquiz23.server.model.Quiz;
import com.sun.javafx.collections.MappingChange;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamesbray on 8/30/16.
 */
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/webquiz23services")
@EnableAutoConfiguration
public class HomeController {

    private static final Logger LOG = LogManager.getLogger(HomeController.class);
    private static final String TAG = "HomeController";

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private DataDelegate delegate = new DataDelegate();

    public static void main(String[] args) {
        SpringApplication.run(HomeController.class, args);
    }

    /**
     * <b>Description</b>
     * <p>
     *     API: <code>http://localhost:8080/webquiz23services/createquiz/{quizname}</code>
     * </p>
     * @param quizname
     * @return
     */
    @RequestMapping(value="/createquiz/{quizname}", method= RequestMethod.POST)
    public Map<String,String> createQuiz(@PathVariable("quizname") String quizname) {
        LOG.debug(TAG + "::ENTER::createQuiz(String)...");
        Map<String,String> data = new HashMap<String, String>();
        Quiz quiz = new Quiz();
        try {
            quiz.setQuizname(URLDecoder.decode(quizname, "UTF-8"));
        } catch(UnsupportedEncodingException uee) {
            LOG.error(TAG + "Error while decoding data:: " + uee.getMessage());
            data.put("data",FAIL);
        }
        boolean result = delegate.createQuiz(quiz);
        if(result == true) {
            data.put("data",SUCCESS);
        }
        LOG.debug(TAG + "::EXIT::createQuiz(String)...");
        return data;
    }
}

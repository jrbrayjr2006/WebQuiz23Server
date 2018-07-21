package com.jaydot2.webquiz23.server.controller;

import com.jaydot2.webquiz23.server.delegate.DataDelegate;
import com.jaydot2.webquiz23.server.model.Quiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jamesbray on 9/3/17.
 */
public class HomeControllerTest {

    MockMvc mockMvc;

    @Mock
    DataDelegate mockDataDelegate;

    HomeController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new HomeController(mockDataDelegate);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createQuiz() throws Exception {
        //Given
        Quiz quiz = new Quiz();
        String dummyQuizName = "dummyQuiz";
        URI dummyUri = new URI("/webquiz23services/createquiz/" + dummyQuizName);

        //When
        when(mockDataDelegate.createQuiz(quiz)).thenReturn(true);
        mockMvc.perform(post(dummyUri)).andExpect(status().isOk()).andReturn();

    }

}
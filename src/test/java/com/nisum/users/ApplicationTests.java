package com.nisum.users;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.users.model.User;
import com.nisum.users.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class ApplicationTests {
    ObjectMapper om = new ObjectMapper();
    @Autowired
    UserRepository userRepository;
    @Autowired
    MockMvc mockMvc;

    Map<String, User> testData;

    @Before
    public void setup() {
        userRepository.deleteAll();
        testData = getTestData();
    }

    @Test
    public void testUserCreation() throws Exception {

    }

    @Test
    public void testGetAllUsers() throws Exception {
    }

    @Test
    public void testGetUserWithId() throws Exception {
    }

    @Test
    public void testGetUserByRepos() throws Exception {
    }

    @Test
    public void testGetUserByUser() throws Exception {
    }


    @Test
    public void testNotAllowedMethod() throws Exception {
    }
    private Map<String, User> getTestData() {
        return null;
    }
}

package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

class ForumTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Suite: begin");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Test Suite: end");
    }
    @DisplayName("When create SimpleUser with realName, than getRealName should return real user name.")
    @Test
    void testCaseRealName(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser","John Smith");
        //When
        String result = simpleUser.getRealname();
        System.out.println("Testing "+result);
        //Then
        Assertions.assertEquals("John Smith", result);
    }
    @DisplayName("When created SimpleUser with name, than getUsername should return correct name.")
    @Test
    void testCaseUsername(){
        //Given
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "theForumUser";
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}

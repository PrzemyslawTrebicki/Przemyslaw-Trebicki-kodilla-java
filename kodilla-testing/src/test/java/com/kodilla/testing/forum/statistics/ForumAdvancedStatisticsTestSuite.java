package com.kodilla.testing.forum.statistics;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumAdvancedStatisticsTestSuite {

    private int testCount;
    private List<String> listOfUsersGenerator(int numberOfUsers){
        List<String> listOfUsers = new ArrayList<>();
        for (int n=1; n<=numberOfUsers; n++){
            String user = new String("User number "+n);
            listOfUsers.add(user);
        }
        return listOfUsers;
    }
    @Mock
    private Statistics statisticsMock;
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Tests Begins!");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("Tests Ended!");
    }
    @BeforeEach
    public void beforeEach(){
        testCount++;
        System.out.println("Test "+testCount);

        when(statisticsMock.postCount()).thenReturn(200);
        when(statisticsMock.commentsCount()).thenReturn(300);
    }
    @AfterEach
    public void afterEach(){
        System.out.println("End of test "+testCount);
    }

    @Test
    void testZeroPosts(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postCount()).thenReturn(0);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        advancedStatistics.showStatistics();
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(0, advancedStatistics.getNumberOfPosts());
        assertEquals(300, advancedStatistics.getNumberOfComments());
        assertEquals(0.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(3.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.0, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }
    @Test
    void testOneThousandPosts(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postCount()).thenReturn(1000);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(1000, advancedStatistics.getNumberOfPosts());
        assertEquals(300, advancedStatistics.getNumberOfComments());
        assertEquals(10.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(3.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.3, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testZeroComments(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(200, advancedStatistics.getNumberOfPosts());
        assertEquals(0, advancedStatistics.getNumberOfComments());
        assertEquals(2.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testLessCommentsThanPosts(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.commentsCount()).thenReturn(100);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(200, advancedStatistics.getNumberOfPosts());
        assertEquals(100, advancedStatistics.getNumberOfComments());
        assertEquals(2.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(1.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(0.5, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testLessPostsThanComments(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postCount()).thenReturn(100);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(100, advancedStatistics.getNumberOfPosts());
        assertEquals(300, advancedStatistics.getNumberOfComments());
        assertEquals(1.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(3.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(3.0, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testZeroUsers(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = new ArrayList<>();
        when(statisticsMock.usersNames()).thenReturn(users);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(0, advancedStatistics.getNumberOfUsers());
        assertEquals(200, advancedStatistics.getNumberOfPosts());
        assertEquals(300, advancedStatistics.getNumberOfComments());
        assertEquals(0.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(0.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1.5, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }

    @Test
    void testOneHundredUsers(){
        //Given
        ForumAdvancedStatistics advancedStatistics = new ForumAdvancedStatistics();
        List<String> users = listOfUsersGenerator(100);
        when(statisticsMock.usersNames()).thenReturn(users);
        //When
        advancedStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        assertEquals(100, advancedStatistics.getNumberOfUsers());
        assertEquals(200, advancedStatistics.getNumberOfPosts());
        assertEquals(300, advancedStatistics.getNumberOfComments());
        assertEquals(2.0, advancedStatistics.getAverageNumberOfPostsPerUser());
        assertEquals(3.0, advancedStatistics.getAverageNumberOfCommentsPerUser());
        assertEquals(1.5, advancedStatistics.getAverageNumberOfCommentsPerPost());
    }
}

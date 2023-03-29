package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite \uD83D \uDE31")
public class ForumTestSuite {
    private static int testCounter =0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }
    @AfterAll
    public static void afterAlltests(){
        System.out.println("All tests are finished.");
    }
    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #"+testCounter);
    }
    @Nested
    @DisplayName("Test for posts.")
    class Testposts {
        //Test 1
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            //When
            forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");
            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        //Test 3
        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrivedPost;
            retrivedPost = forumUser.getPost(0);
            //Then
            Assertions.assertEquals(thePost, retrivedPost);
        }

        //Test 5
        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contibution here!", "mrsmith");
            //When
            boolean result = forumUser.removePost(thePost);
            //then
            Assertions.assertFalse(result);
        }

        //Test 7
        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            boolean result = forumUser.removePost(thePost);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }
    @Nested
    @DisplayName("Tests for comments")
    class TestComment {
        //Test 2
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you for good words!");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        //Test 4
        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            ForumComment retrivedComment = forumUser.getComment(0);
            //Then
            Assertions.assertEquals(theComment, retrivedComment);
        }

        //Test 6
        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words!");
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertFalse(result);
        }

        //Test 8
        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith", "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
            //When
            boolean result = forumUser.removeComment(theComment);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}

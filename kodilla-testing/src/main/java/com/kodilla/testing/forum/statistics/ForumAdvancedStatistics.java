package com.kodilla.testing.forum.statistics;

public class ForumAdvancedStatistics {

    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics){
        numberOfUsers = statistics.usersNames().size();
        numberOfPosts = statistics.postCount();
        numberOfComments = statistics.commentsCount();
        if(numberOfUsers > 0){
            averageNumberOfPostsPerUser = numberOfPosts / (double)numberOfUsers;
            averageNumberOfCommentsPerUser = numberOfComments / (double)numberOfUsers;
        }
        if(numberOfPosts > 0){
            averageNumberOfCommentsPerPost = numberOfComments / (double)numberOfPosts;
        }
    }

    public void showStatistics(){
        System.out.println("Forum advanced statistic:");
        System.out.println("Number of users: "+numberOfUsers+".");
        System.out.println("Number of posts: "+numberOfPosts+".");
        System.out.println("Number of comments: "+numberOfComments+".");
        System.out.println("Average number of posts per user: "+averageNumberOfPostsPerUser+".");
        System.out.println("Average number of comments per user: "+averageNumberOfCommentsPerPost+".");
        System.out.println("Average number of comments per post: "+averageNumberOfCommentsPerPost+".");
    }
}

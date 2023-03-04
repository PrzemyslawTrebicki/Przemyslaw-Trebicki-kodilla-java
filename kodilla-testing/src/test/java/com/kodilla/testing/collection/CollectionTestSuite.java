package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    private static OddNumbersExterminator oddNumbersExterminator;
    @BeforeEach
    public void before(){
        System.out.println("Test begins.");
    }
    @AfterEach
    public void after(){
        System.out.println("Test ends.");
    }
    @DisplayName("Empty list test.")
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> emptyList=new ArrayList<>();
        //When
        List<Integer> resultList=oddNumbersExterminator.exterminate(emptyList);
        System.out.println("List empty");
        //Then
        Assertions.assertEquals(emptyList, resultList);
    }
    @DisplayName("Normal list test.")
    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        ArrayList<Integer> normalList=new ArrayList<>();
        normalList.add(1);
        normalList.add(2);
        normalList.add(3);
        normalList.add(4);
        normalList.add(5);
        normalList.add(6);
        normalList.add(7);
        normalList.add(8);
        normalList.add(9);
        normalList.add(10);
        ArrayList<Integer> expectedResults=new ArrayList<>();
        expectedResults.add(2);
        expectedResults.add(4);
        expectedResults.add(6);
        expectedResults.add(8);
        expectedResults.add(10);
        //When
        List<Integer> results=oddNumbersExterminator.exterminate(normalList);
        System.out.println("Normal list testing.");
        //Then
        Assertions.assertEquals(expectedResults,results);
    }
}

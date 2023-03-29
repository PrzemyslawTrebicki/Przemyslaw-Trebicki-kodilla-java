package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Test begins here.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("Tests ended.");
    }

    @BeforeEach
    public void beforeEachTest() {
        testCounter++;
        System.out.println("Test number: " + testCounter + " begins.");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test number: " + testCounter + " ends.");
    }

    @Nested
    @DisplayName("Circle ShapeCollector Tests.")
    class TestsShapeCollectorCircles {
        //Test 1
        //test dodający figurę do kolekcji
        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Owal", 1.0);
            //When
            shapeCollector.addFigure(shape);
            //Then
            Assertions.assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        //Test 2
        //test usuwający figurę z kolekcji
        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Owal1", 2.0);
            shapeCollector.addFigure(shape);
            //When
            shapeCollector.removeFigure(shape);
            //Then
            Assertions.assertEquals(0, shapeCollector.getShapeCollection().size());
        }

        //Test 3
        //test pobierający figurę z poz. n listy
        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle("Owal", 3.0);
            Shape shape1 = new Circle("Kolo", 3.2);
            //When
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape1);
            //Then
            Assertions.assertEquals(shape1, shapeCollector.getFigure(1));
        }
    }

    //Test 4
    //test zwracający nazwy wszystkich figur w kolekcji
    @Nested
    @DisplayName("Test for all names.")
    class TestForAllNames {
        @Test
        void testGetAllNames() {
            //Given
            ShapeCollector shapeCollector =new ShapeCollector();
            Shape shape = new Circle("Okreg", 4.0);
            Shape shape1 = new Circle("Kolo", 4.2);
            Shape shape2 = new Circle("Okrag",4.6);
            //When
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);
            //Then
            Assertions.assertEquals(" "+shape.getShapeName()+" "+shape1.getShapeName()+" "+shape2.getShapeName(), shapeCollector.showFigures());
        }
    }
}

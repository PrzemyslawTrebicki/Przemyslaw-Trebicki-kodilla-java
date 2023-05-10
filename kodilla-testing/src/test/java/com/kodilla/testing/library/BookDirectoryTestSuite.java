package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity){
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title"+n, "Author" + n,1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    @Test
    void testListBooksWithConditionsReturnList(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo","John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors","Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers","Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java","Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
        //Then
        assertEquals(4, theListOfBooks.size());
    }
    @Test
    void testListBooksWithConditionMoreThan20(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf30Books = generateListOfNBooks(30);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("ThirtyBooks")).thenReturn(resultListOf30Books);
        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks30 = bookLibrary.listBooksWithCondition("ThirtyBooks");
        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks30.size());
    }
    @Test
    void testListBooksWithConditionFragmentShorterThan3(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");
        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    // Zadanie domowe
    @Test
    void testListBooksInHandsOfFiveBooks(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> thelistOfZeroBooks = new ArrayList<>();
        LibraryUser john = new LibraryUser("John", "Smith", "1234567890" );
        when(libraryDatabaseMock.listBooksInHandsOf(john)).thenReturn(thelistOfZeroBooks);
        //When
        List<Book> listOfZeroBooks = bookLibrary.listBookInHandsOf(john);
        //Then
        assertEquals(0, thelistOfZeroBooks.size());
    }

    @Test
    void testListBooksInHandsOfOneBook(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> thelistOfOneBook = generateListOfNBooks(1);
        LibraryUser john = new LibraryUser("John", "Smith", "1234567890" );
        when(libraryDatabaseMock.listBooksInHandsOf(john)).thenReturn(thelistOfOneBook);
        //When
        List<Book> listOfOneBook = bookLibrary.listBookInHandsOf(john);
        //Then
        assertEquals(1, thelistOfOneBook.size());
    }

    @Test
    void testListBooksInHandsOfZeroBooks(){
        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> thelistOfFiveBooks = generateListOfNBooks(5);
        LibraryUser johny = new LibraryUser("John", "With", "0987654321" );
        when(libraryDatabaseMock.listBooksInHandsOf(johny)).thenReturn(thelistOfFiveBooks);
        //When
        List<Book> listOfFiveBooks = bookLibrary.listBookInHandsOf(johny);
        //Then
        assertEquals(5, thelistOfFiveBooks.size());
    }

}

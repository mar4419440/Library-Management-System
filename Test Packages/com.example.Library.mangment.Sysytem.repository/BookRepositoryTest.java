/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Library.mangment.Sysytem.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import model.Book;
import Repository.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        // Create a new Book object
        Book book = new Book();
        book.setBookTitle("Test Book");
        book.setBookAuthor("Test Author");

        // Save the book
        Book savedBook = bookRepository.save(book);

        // Verify that the saved book has an ID assigned
        assertNotNull(savedBook.getBookId());
    }

    @Test
    public void testFindAllBooks() {
        // Retrieve all books from the repository
        List<Book> books = bookRepository.findAll();

        // Verify that the list is not empty
        assertNotNull(books);

        // You can add more assertions based on your specific requirements
        // For example, you can check the size of the list or verify the attributes of each book
    }
}



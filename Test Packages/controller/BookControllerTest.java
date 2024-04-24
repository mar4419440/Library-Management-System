/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.BookService;
import model.Book;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book();
        book.setBookTitle("Test Book");

        // Perform a POST request to create a book
        ResultActions resultActions = mockMvc.perform(post("/Book")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{ \"title\": \"Test Book\" }"));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the bookService's createBook method is called
        Mockito.verify(bookService, Mockito.times(1)).createBook(book);
    }

    @Test
    public void testUpdateBook() throws Exception {
        Long bookId = 1L;
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookTitle("Updated Test Book");

        // Perform a PUT request to update a book
        ResultActions resultActions = mockMvc.perform(put("/Book")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{ \"id\": 1, \"title\": \"Updated Test Book\" }"));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the bookService's UpdateBook method is called
        Mockito.verify(bookService, Mockito.times(1)).UpdateBook(book);
    }

    @Test
    public void testDeleteBook() throws Exception {
        Long bookId = 1L;

        // Perform a DELETE request to delete a book
        ResultActions resultActions = mockMvc.perform(delete("/Book/{bookId}", bookId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the bookService's deleteBook method is called
        Mockito.verify(bookService, Mockito.times(1)).DeleteBook(bookId);
    }

    @Test
    public void testGetBook() throws Exception {
        Long bookId = 1L;
        Book book = new Book();
        book.setBookId(bookId);
        book.setBookTitle("Test Book");

        Mockito.when(bookService.getBook(bookId)).thenReturn(book);

        // Perform a GET request to retrieve a book
        ResultActions resultActions = mockMvc.perform(get("/Book/{bookId}", bookId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$.id").value(bookId))
                     .andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        // Perform a GET request to retrieve all books
        ResultActions resultActions = mockMvc.perform(get("/Book")
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the bookService's getAllBooks method is called
        Mockito.verify(bookService, Mockito.times(1)).getAllBook();
    }
}


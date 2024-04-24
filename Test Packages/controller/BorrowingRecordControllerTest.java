/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.BorrowingRecordService;
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
public class BorrowingRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @Test
    public void testBorrowBook() throws Exception {
        Long bookId = 1L;
        Long patronId = 1L;

        // Perform a POST request to borrow a book
        ResultActions resultActions = mockMvc.perform(post("/api/borrowing/borrow/{bookId}/patron/{patronId}", bookId, patronId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the borrowingRecordService's createBorrowingRecord method is called
        Mockito.verify(borrowingRecordService, Mockito.times(1)).createBorrowingRecord(bookId, patronId);
    }

    @Test
    public void testReturnBook() throws Exception {
        Long bookId = 1L;
        Long patronId = 1L;

        // Perform a PUT request to return a book
        ResultActions resultActions = mockMvc.perform(put("/api/borrowing/return/{bookId}/patron/{patronId}", bookId, patronId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the borrowingRecordService's returnBook method is called
        Mockito.verify(borrowingRecordService, Mockito.times(1)).returnBook(bookId, patronId);
    }

    // Add more test methods to cover other endpoints of the BorrowingRecordController
}


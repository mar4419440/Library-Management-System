/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Library.mangment.Sysytem.repository;

import Repository.BorrowingRecordRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import model.BorrowingRecord;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@SpringBootTest
@AutoConfigureTestDatabase
public class BorrowingRecordRepositoryTest {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Test
    public void testSaveBorrowingRecord() {
        // Create a borrowing record
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBorrowDate(LocalDate.now());
        borrowingRecord.setReturnDate(new Date());

        // Save the borrowing record
        BorrowingRecord savedRecord = borrowingRecordRepository.save(borrowingRecord);

        // Verify that the borrowing record was saved successfully
        assertNotNull(savedRecord.getBorrowingId());
    }

    @Test
    public void testFindBorrowingRecordByBookIdAndPatronId() {
        // Assuming bookId and patronId are valid IDs
        Long bookId = 1L;
        Long patronId = 1L;

        // Find the borrowing record by bookId and patronId
        BorrowingRecord foundRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);

        // Verify that the borrowing record is not null
        assertNotNull(foundRecord);

        // Verify that the book ID and patron ID match
        assertEquals(bookId, foundRecord.getBook().getBookId());
        assertEquals(patronId, foundRecord.getPatron().getPatronId());
    }

}

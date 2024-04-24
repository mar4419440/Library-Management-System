/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.BookRepository;
import Repository.BorrowingRecordRepository;
import Repository.PatronRepository;
import Service.BorrowingRecordService;
import exception.BorrowingRecordNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import model.Book;
import model.BorrowingRecord;
import model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service
@Transactional 
public class BorrowingRecordServiceImpl implements BorrowingRecordService{
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;
    
    @Autowired
    public BorrowingRecordServiceImpl(BorrowingRecordRepository borrowingRecordRepository, BookRepository bookRepository, PatronRepository patronRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.bookRepository = bookRepository;
        this.patronRepository = patronRepository;
    }

    @Override
    public void createBorrowingRecord(Long bookId, Long patronId) {
       Book book = bookRepository.findById(bookId).get();

        Patron patron = patronRepository.findById(patronId).get();

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());

        borrowingRecordRepository.save(borrowingRecord); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public void returnBook(Long bookId, Long patronId) {
    // Find the borrowing record for the given bookId and patronId
    BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);

    // Check if the borrowing record exists
    if (borrowingRecord != null) {
        // Set the return date to the current date
        Date currentDate =new  Date();
        borrowingRecord.setReturnDate(currentDate);

        // Save the updated borrowing record
        borrowingRecordRepository.save(borrowingRecord);
    } else {
        throw new BorrowingRecordNotFoundException("Borrowing record not found for book ID: " + bookId + " and patron ID: " + patronId);
    }
}



     @Override
     @Transactional(readOnly = true) 
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }
    
}

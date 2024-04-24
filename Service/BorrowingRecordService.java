/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.BorrowingRecord;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public interface BorrowingRecordService {
    void createBorrowingRecord(Long bookId, Long patronId);
    void returnBook(Long bookId, Long patronId);
    List<BorrowingRecord> getAllBorrowingRecords();
}

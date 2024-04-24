import Repository.BookRepository;
import Repository.BorrowingRecordRepository;
import Repository.PatronRepository;
import Service.ServiceImpl.BorrowingRecordServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import exception.BookNotFoundException;
import exception.PatronNotFoundException;
import model.Book;
import model.BorrowingRecord;
import model.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class BorrowingRecordServiceImplTest {

    @Mock
    private BorrowingRecordRepository borrowingRecordRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private BorrowingRecordServiceImpl borrowingRecordService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBorrowingRecord_WhenBookNotFound_ThrowsBookNotFoundException() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(BookNotFoundException.class, () -> borrowingRecordService.createBorrowingRecord(bookId, patronId));
    }

    @Test
    public void testCreateBorrowingRecord_WhenPatronNotFound_ThrowsPatronNotFoundException() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
        when(patronRepository.findById(patronId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(PatronNotFoundException.class, () -> borrowingRecordService.createBorrowingRecord(bookId, patronId));
    }

    @Test
    public void testReturnBook_WhenBorrowingRecordExists_ReturnsBook() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        when(borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId)).thenReturn(borrowingRecord);

        // Act
        borrowingRecordService.returnBook(bookId, patronId);

        // Assert
        assertNotNull(borrowingRecord.getReturnDate());
        assertEquals(LocalDate.now(), borrowingRecord.getReturnDate());
    }

    @Test
    public void testReturnBook_WhenBorrowingRecordNotExists_NoActionTaken() {
        // Arrange
        Long bookId = 1L;
        Long patronId = 1L;
        when(borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId)).thenReturn(null);

        // Act
        borrowingRecordService.returnBook(bookId, patronId);

        // Assert
        verify(borrowingRecordRepository, never()).save(any());
    }
}

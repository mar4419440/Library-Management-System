package Service.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import Repository.BookRepository;
import exception.BookNotFoundException;
import model.Book;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBookById() {
        // Arrange
        Long bookId = 1L;
        Book mockBook = new Book();
        mockBook.setBookId(bookId);
        mockBook.setBookTitle("Mock Book");
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(mockBook));

        // Act
        Book result = bookService.getBook(bookId);

        // Assert
        assertEquals(mockBook, result);
    }

    @Test
    void testGetBookByIdNotFound() {
        // Arrange
        Long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(BookNotFoundException.class, () -> bookService.getBook(bookId));
    }

    @Test
    void testGetAllBooks() {
        // Arrange
        List<Book> mockBooks = new ArrayList<>();
        mockBooks.add(new Book());
        mockBooks.add(new Book());
        when(bookRepository.findAll()).thenReturn(mockBooks);

        // Act
        List<Book> result = bookService.getAllBook();

        // Assert
        assertEquals(mockBooks.size(), result.size());
    }

    // Additional test methods for other service methods can be added similarly
}

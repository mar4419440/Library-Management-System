/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.BookRepository;
import Service.BookService;
import exception.BookDeleteException;
import exception.BookNotFoundException;
import exception.BookUpdateException;
import java.util.List;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service
@Transactional
public class BookServiceImpl implements BookService{
    BookRepository bookRepository;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
      
    }

    @Override
    public void UpdateBook(Book book) {
    try {
        bookRepository.save(book);
    } catch (Exception e) {
        throw new BookUpdateException("Failed to update book", e);
    }
}


   @Override
    public void DeleteBook(Long bookID) {
        try {
            bookRepository.deleteById(bookID);
        } catch (Exception e) {
            throw new BookDeleteException("Failed to delete book", e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBook(Long bookID) {
        
        if(bookRepository.findById(bookID).isEmpty()){
            throw new BookNotFoundException("Requested Book Does not Exist");
        }
       return bookRepository.findById(bookID).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }
    
}

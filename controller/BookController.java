/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.BookService;
import java.util.List;
import model.Book;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/Book")
@Validated 
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }
    
    @PutMapping
    public void UpdateBook(@RequestBody Book book){
        bookService.UpdateBook(book);
    }
    
    @DeleteMapping("{bookId}")
    public void DeleteBook(@PathVariable("bookId")long bookId){
        bookService.DeleteBook(bookId);
    }
    
    @GetMapping("{bookId}")
    public Book getBook(@PathVariable("bookId") long bookId){
        return bookService.getBook(bookId);
    }
    
    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }
}

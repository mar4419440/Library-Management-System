/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.Book;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public interface BookService {
    public void createBook(Book book);
    public void UpdateBook(Book book);
    public void DeleteBook(Long bookID);
    public Book getBook(Long bookID);
    public List<Book> getAllBook();
}

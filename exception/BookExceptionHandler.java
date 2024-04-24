/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author ADMIN
 */



@ControllerAdvice
public class BookExceptionHandler {
    
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException bookNotFoundException){
        BookException bookException = new BookException(bookNotFoundException.getMessage(), bookNotFoundException.getCause(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bookException, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(value = {BookUpdateException.class})
    public ResponseEntity<Object> handleBookUpdateException(BookUpdateException bookUpdateException){
        BookException bookException = new BookException(bookUpdateException.getMessage(), bookUpdateException.getCause(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(bookException, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(value = {BookDeleteException.class})
    public ResponseEntity<Object> handleBookDeleteException(BookDeleteException bookDeleteException){
        BookException bookException = new BookException(bookDeleteException.getMessage(), bookDeleteException.getCause(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(bookException, HttpStatus.BAD_REQUEST);
    }
}


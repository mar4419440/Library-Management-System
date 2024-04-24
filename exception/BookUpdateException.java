/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author ADMIN
 */

public class BookUpdateException extends RuntimeException {

    public BookUpdateException(String message) {
        super(message);
    }

    public BookUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}

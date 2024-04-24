package exception;

public class PatronCreateException extends RuntimeException {

    public PatronCreateException(String message) {
        super(message);
    }

    public PatronCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}

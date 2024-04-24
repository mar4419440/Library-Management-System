package exception;

public class PatronUpdateException extends RuntimeException {

    public PatronUpdateException(String message) {
        super(message);
    }

    public PatronUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}

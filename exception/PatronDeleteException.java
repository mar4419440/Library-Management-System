package exception;

public class PatronDeleteException extends RuntimeException {

    public PatronDeleteException(String message) {
        super(message);
    }

    public PatronDeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}

package exception;

public class NotAValidInputException extends RuntimeException {

    public NotAValidInputException(String message) {
        super(message);
    }
}

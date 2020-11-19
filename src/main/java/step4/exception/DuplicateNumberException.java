package step4.exception;

public class DuplicateNumberException extends RuntimeException{
    public DuplicateNumberException() {
    }

    public DuplicateNumberException(String message) {
        super(message);
    }
}

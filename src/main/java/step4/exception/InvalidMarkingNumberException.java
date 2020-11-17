package step4.exception;

public class InvalidMarkingNumberException extends RuntimeException{
    public InvalidMarkingNumberException() {
    }

    public InvalidMarkingNumberException(String message) {
        super(message);
    }
}

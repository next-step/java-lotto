package step2.exception;

public class CustomNumberFormatException extends RuntimeException{

    public CustomNumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomNumberFormatException(String message) {
        super(message);
    }
}

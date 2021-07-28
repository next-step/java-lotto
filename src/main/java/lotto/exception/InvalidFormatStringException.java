package lotto.exception;

public class InvalidFormatStringException extends RuntimeException {
    public InvalidFormatStringException() {
        super();
    }

    public InvalidFormatStringException(String message) {
        super(message);
    }

    public InvalidFormatStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormatStringException(Throwable cause) {
        super(cause);
    }

    protected InvalidFormatStringException(String message, Throwable cause,
                                  boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

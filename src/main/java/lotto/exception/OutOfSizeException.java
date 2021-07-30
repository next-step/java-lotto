package lotto.exception;

public class OutOfSizeException extends RuntimeException {
    public OutOfSizeException() {
        super();
    }

    public OutOfSizeException(String message) {
        super(message);
    }

    public OutOfSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfSizeException(Throwable cause) {
        super(cause);
    }

    protected OutOfSizeException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

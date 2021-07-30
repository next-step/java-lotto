package lotto.exception;

public class OverlapNumberException extends RuntimeException {
    public OverlapNumberException() {
        super();
    }

    public OverlapNumberException(String message) {
        super(message);
    }

    public OverlapNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverlapNumberException(Throwable cause) {
        super(cause);
    }

    protected OverlapNumberException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
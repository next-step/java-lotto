package lotto.exception;

public class NumberNotSupportException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "지원 되지 않는 Number Format 입니다.";
    public NumberNotSupportException() {
        super();
    }

    public NumberNotSupportException(String message) {
        super(message);
    }

    public NumberNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberNotSupportException(Throwable cause) {
        super(cause);
    }

    protected NumberNotSupportException(String message, Throwable cause,
                                           boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

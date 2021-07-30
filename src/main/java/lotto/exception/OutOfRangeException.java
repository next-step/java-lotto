package lotto.exception;

public class OutOfRangeException extends RuntimeException {
    private static final String DEFAULT_EXCEPTION_MESSAGE = "요청한 값이 허용 범위를 넘었습니다.";

    public OutOfRangeException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfRangeException(Throwable cause) {
        super(cause);
    }

    protected OutOfRangeException(String message, Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

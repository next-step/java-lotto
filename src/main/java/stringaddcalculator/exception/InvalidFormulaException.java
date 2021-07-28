package stringaddcalculator.exception;

public class InvalidFormulaException extends RuntimeException {
    private static final String DEFAULT_EXCEPTION_MESSAGE = "유효하지 않은 수식 입니다.";

    public InvalidFormulaException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public InvalidFormulaException(String message) {
        super(message);
    }

    public InvalidFormulaException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormulaException(Throwable cause) {
        super(cause);
    }

    protected InvalidFormulaException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

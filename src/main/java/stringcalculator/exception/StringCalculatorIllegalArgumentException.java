package stringcalculator.exception;

public class StringCalculatorIllegalArgumentException extends RuntimeException {
    public static final StringCalculatorIllegalArgumentException INVALID_EMPTY_INPUT = new StringCalculatorIllegalArgumentException("입력값이 비어있습니다.");
    public StringCalculatorIllegalArgumentException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

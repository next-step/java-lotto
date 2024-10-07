package stringcalculator.exception;

public class StringCalculatorIllegalArgumentException extends IllegalArgumentException {
    public StringCalculatorIllegalArgumentException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

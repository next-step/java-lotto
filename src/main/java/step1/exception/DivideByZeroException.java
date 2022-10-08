package step1.exception;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException(String message) {
        super(message);
    }
}

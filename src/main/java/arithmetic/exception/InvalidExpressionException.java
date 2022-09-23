package arithmetic.exception;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException() {
        super("Expression is invalid format.");
    }
}

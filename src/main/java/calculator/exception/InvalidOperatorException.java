package calculator.exception;

public class InvalidOperatorException extends RuntimeException {

    private static final String INVALID_OPERATOR_MESSAGE = "올바른 연산자가 아닙니다";
    public InvalidOperatorException() {
        super(INVALID_OPERATOR_MESSAGE);
    }
}

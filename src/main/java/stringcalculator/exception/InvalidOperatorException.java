package stringcalculator.exception;

public class InvalidOperatorException extends RuntimeException {

    private static final String INVALID_OPERATOR_ERROR_MESSAGE = "연산자는 \"+, -, *, %\" 만 가능합니다.";

    public InvalidOperatorException() {
        super(INVALID_OPERATOR_ERROR_MESSAGE);
    }
}

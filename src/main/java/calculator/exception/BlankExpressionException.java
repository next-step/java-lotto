package calculator.exception;

public class BlankExpressionException extends RuntimeException {

    private static final String BLANK_EXPRESSION_MESSAGE = "공백 문자열 입니다.";

    public BlankExpressionException() {
        super(BLANK_EXPRESSION_MESSAGE);
    }
}

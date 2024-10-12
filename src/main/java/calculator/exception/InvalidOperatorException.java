package calculator.exception;

public class InvalidOperatorException extends IllegalArgumentException {

    public static final String ERROR_MESSAGE = "는 잘못된 연산기호 입니다";

    public InvalidOperatorException(String invalidOperator) {
        super(invalidOperator + ERROR_MESSAGE);
    }

}

package step1.exception;

public class NotOperatorException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "사칙 연산 기호가 아닙니다";

    public NotOperatorException() {
        super(ERROR_MESSAGE);
    }

}

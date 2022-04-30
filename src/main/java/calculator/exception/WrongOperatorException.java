package calculator.exception;

public class WrongOperatorException extends IllegalArgumentException {
    private static final String MESSAGE = "사칙연산자만 사용할 수 있습니다.";

    public WrongOperatorException() {
        super(MESSAGE);
    }
}

package calculator.exception;

public class WrongOperatorException extends IllegalArgumentException {
    private static final String MESSAGE = "사칙연산, 공백, 숫자 외의 값이 있습니다";

    public WrongOperatorException() {
        super(MESSAGE);
    }
}

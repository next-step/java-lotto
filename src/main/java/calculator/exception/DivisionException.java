package calculator.exception;

public class DivisionException extends IllegalArgumentException {

    private static final String MESSAGE = "나눗셈 값으로 0을 입력할 수 없습니다.";

    public DivisionException() {
        super(MESSAGE);
    }

    public DivisionException(String message) {
        super(message);
    }
}

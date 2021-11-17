package calculator.exception;

public class AdditionNumberFormatException extends NumberFormatException {

    private static final String MESSAGE = "올바르지 못한 계산식을 입력하셨습니다.";

    public AdditionNumberFormatException() {
        super(MESSAGE);
    }

}

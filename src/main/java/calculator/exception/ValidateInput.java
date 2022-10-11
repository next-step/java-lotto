package calculator.exception;

public class ValidateInput extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값이 없습니다.";

    public ValidateInput() {
        super(MESSAGE);
    }
}

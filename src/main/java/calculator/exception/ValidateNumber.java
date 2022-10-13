package calculator.exception;

public class ValidateNumber extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값을 다시 입력해 주세요.";

    public ValidateNumber() {
        super(MESSAGE);
    }
}

package calculator.exception;

public class CustomFormaterException extends IllegalArgumentException {

    private static final String MESSAGE = "커스텀 계산 식이 아닙니다.";

    public CustomFormaterException() {
        super(MESSAGE);
    }

}

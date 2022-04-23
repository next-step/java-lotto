package calculator.exception;

public class EmptyValueException extends IllegalArgumentException {
    private static final String MESSAGE = "입력 값이 null 이거나 비어 있습니다.";

    public EmptyValueException() {
        super(MESSAGE);
    }
}

package calculator.exception;

public class AdditionIllegalArgumentException extends IllegalArgumentException {

    private static final String MESSAGE = "0보다 작은 값은 계산할 수 없습니다.";

    public AdditionIllegalArgumentException() {
        super(MESSAGE);
    }

}

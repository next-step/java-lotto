package calculator.exception;

public class ValidateOperator extends IllegalArgumentException {

    private static final String MESSAGE = "사칙연산 기호를 입력해 주세요";

    public ValidateOperator() {
        super(MESSAGE);
    }
}

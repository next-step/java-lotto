package calculator;

public class PositiveNumber {
    private static final String NOT_VALID_ARGUMENT_EXIST_STATEMENT = "음수 또는 0이 존재합니다";
    private final int positiveNumber;

    public PositiveNumber(int positiveNumber) {
        validate(positiveNumber);
        this.positiveNumber = positiveNumber;
    }

    private void validate(int positiveNumber) {
        if (positiveNumber <= 0) {
            throw new RuntimeException(NOT_VALID_ARGUMENT_EXIST_STATEMENT);
        }
    }

    public int number() {
        return this.positiveNumber;
    }
}

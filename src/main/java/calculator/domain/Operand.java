package calculator.domain;

public class Operand {

    private static final int LIMIT_MINIMUM_NUMBER = 0;

    private final int value;

    public Operand(String operandString) {
        this.value = castToInteger(operandString);

        validPositiveNumber(value);
    }

    public int getValue() {
        return value;
    }

    public Integer castToInteger(String operandString) {
        try {
            return Integer.parseInt(operandString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
        }
    }

    private void validPositiveNumber(Integer value) {
        if (value < LIMIT_MINIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 음수 값은 입력할 수 없습니다.");
        }
    }
}

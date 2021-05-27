package calculator.domain;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class CalculatorNumber {
    private static final int MINIMUM_NUMBER = 0;
    private static final String NO_NEGATIVE_MESSAGE = "음수는 가질 수 없습니다.";

    private int value;

    public CalculatorNumber(String number) {
        int allocatingValue = parseInt(number);
        validate(allocatingValue);

        this.value = allocatingValue;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorNumber that = (CalculatorNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(int allocatingValue) {
        if (allocatingValue < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(NO_NEGATIVE_MESSAGE);
        }
    }
}

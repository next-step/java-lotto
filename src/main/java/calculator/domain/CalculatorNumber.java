package calculator.domain;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class CalculatorNumber {
    private static final int MINIMUM_NUMBER = 0;

    private int value;

    public CalculatorNumber(String number) {
        this.value = parseInt(number);

        if (this.value < MINIMUM_NUMBER) {
            throw new RuntimeException("음수는 가질 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
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
}

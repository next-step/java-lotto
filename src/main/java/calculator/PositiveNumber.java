package calculator;

import java.util.Objects;

public class PositiveNumber {
    public static final int MIN_NUMBER_INPUT = 0;
    private int number;

    public PositiveNumber(int number) {
        if (number < MIN_NUMBER_INPUT) {
            throw new RuntimeException("음수는 계산할 수 없습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

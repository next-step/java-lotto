package study2.domain;

import java.util.Objects;

public class PositiveNumber {

    private final int number;

    private PositiveNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 존재합니다.");
        }
    }

    public static PositiveNumber of(String number) {
        return new PositiveNumber(Integer.parseInt(number));
    }

    public static PositiveNumber of(int number) {
        return new PositiveNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PositiveNumber that = (PositiveNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int number() {
        return number;
    }
}

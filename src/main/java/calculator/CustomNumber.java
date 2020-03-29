package calculator;

import java.util.Objects;

public class CustomNumber {
    private static final int MIN_NUMBER = 0;

    private final int number;

    public CustomNumber(int number) {
        verifyNotNegative(number);
        this.number = number;
    }

    private void verifyNotNegative(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format("숫자에 음수 값(%d)이 들어올 수 없습니다.", number));
        }
    }

    public int getNumber() {
        return number;
    }

    public static CustomNumber of(int input) {
        return new CustomNumber(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomNumber)) return false;
        CustomNumber that = (CustomNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

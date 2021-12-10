package lotto.domain;

import java.util.Objects;

public class Number {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int number;

    Number(int number) {
        validate(number);
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private void validate(int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("번호는 [" + MIN_NUMBER + "," + MAX_NUMBER + "]의 범위 안에 있어야합니다.");
        }
    }

    private boolean isInvalidNumber(int number) {
        return MIN_NUMBER > number || MAX_NUMBER < number;
    }
}

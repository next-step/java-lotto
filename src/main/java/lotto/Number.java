package lotto;

import java.util.Objects;

public class Number {
    private final int value;

    public Number(int value) {
        this.value = validateNumber(value);
    }

    public int getValue() {
        return value;
    }

    private int validateNumber(int value) {
        if (value <= 0 || value > 45) {
            throw new IllegalArgumentException("번호가 생성가능한 범위는 1~45까지 입니다.");
        }

        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return getValue() == number.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}

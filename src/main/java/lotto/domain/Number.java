package lotto.domain;

import java.util.Objects;

public class Number {
    private final int number;

    public Number(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1부터 45까지 숫자만 입력해 주세요.");
        }
        this.number = number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

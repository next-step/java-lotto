package lotto.domain;

import java.util.Objects;

public class Number {
    private final Integer number;

    public Number(int number) {
        checkBound(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void checkBound(Integer number) {
        if (number > 45) {
            throw new IllegalArgumentException("45보다 큰 숫자가 입력될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return Objects.equals(number, number1.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

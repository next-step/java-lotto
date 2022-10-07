package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int MIN_VALUE = 0;

    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(String.format("%d 이상의 정수를 입력해야 합니다.", MIN_VALUE));
        }
    }

    public int divideBy(Money money) {
        if (money.value == 0) {
            throw new IllegalArgumentException("0원으로 나눌 없습니다.");
        }
        return this.value / money.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

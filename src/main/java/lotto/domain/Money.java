package lotto.domain;

import java.util.Objects;

public class Money {

    private static final int MIN_VALUE = 0;
    private final int value;

    public Money(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}

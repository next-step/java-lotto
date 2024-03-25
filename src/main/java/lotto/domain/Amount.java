package lotto.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.stream.IntStream;

public class Amount {
    private final int value;

    public Amount(BigDecimal value) {
        this(value.intValue());
    }

    public Amount(int value) {
        assertAmountPositive(value);
        this.value = value;
    }

    private void assertAmountPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("수량은 음수가 될 수 없습니다.");
        }
    }

    public int value() {
        return this.value;
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public IntStream range() {
        return IntStream.range(0, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

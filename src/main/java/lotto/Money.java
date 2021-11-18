package lotto;

import java.util.Objects;

public class Money implements Comparable<Money> {
    private final int value;
    private static final int ZERO = 0;

    public Money(int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("돈은 0 미만의 값을 가질 수 없습니다.");
        }

        this.value = value;
    }

    public Money minus(int weight, Money other) {
        return this.minus(new Money(weight * other.value));
    }

    public Money minus(Money other) {
        if (other.value > this.value) {
            throw new IllegalArgumentException("현재 가지고 있는 돈이 부족합니다.");
        }

        return new Money(this.value - other.value);
    }

    public boolean lessThan(Money other) {
        return this.compareTo(other) < 0;
    }

    public int quotient(Money unitPrice) {
        if (unitPrice.value == ZERO) {
            throw new IllegalArgumentException("로또의 가격은 0이 될 수 없습니다.");
        }

        return this.value / unitPrice.value;
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
    public int compareTo(Money other) {
        return this.value - other.value;
    }
}

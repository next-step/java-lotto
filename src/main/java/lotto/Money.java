package lotto;

import java.util.Objects;

public class Money implements Comparable<Money> {
    private final int value;
    private static final int ZERO = 0;

    public Money(int value) {
        this.value = value;
    }

    public Money minus(int value) {
        if (value > this.value) {
            throw new IllegalArgumentException("현재 가지고 있는 돈이 부족합니다.");
        }

        return new Money(this.value - value);
    }

    public Money minus(int weight, Money money) {
        return this.minus(weight * money.value);
    }

    public boolean lessThan(Money unitPrice) {
        return this.compareTo(unitPrice) < 0;
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

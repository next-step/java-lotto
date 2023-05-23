package lotto.model;

import java.util.Objects;

public class Money {

    private final long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    public long amount() {
        return this.amount;
    }

    public Money plus(Money other) {
        return new Money(this.amount + other.amount);
    }

    public double divide(Money other) {
        return (double) this.amount / other.amount;
    }

    private void validate(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return amount == money1.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

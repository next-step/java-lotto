package lotto.domain;

import java.util.Objects;

public class Money {

    private final int amount;

    public Money(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
        }
        this.amount = amount;
    }

    public int buyCount(Money price) {
        return this.amount / price.amount;
    }

    public double ratio(Money other) {
        return (double) this.amount / other.amount;
    }

    public int amount() {
        return this.amount;
    }

    public boolean isMultiple(int amount) {
        return amount % this.amount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

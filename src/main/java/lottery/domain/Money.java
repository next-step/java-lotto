package lottery.domain;

import java.util.Objects;

public class Money {

    public static final Money ZERO = new Money(0);

    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money valueOf(int amount) {
        return amount == 0 ? ZERO : new Money(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    public Money add(Money addend) {
        return Money.valueOf(this.amount + addend.amount);
    }

    public Money times(Money multiplier) {
        return Money.valueOf(this.amount * multiplier.amount);
    }

    public Money divide(Money divisor) {
        return Money.valueOf(this.amount / divisor.amount);
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

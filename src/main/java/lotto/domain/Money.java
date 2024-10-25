package lotto.domain;

import java.util.Objects;

public class Money {

    private static Money ZERO = new Money(0);
    private final int amount;

    public Money(int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException("돈은 음수일수 없습니다.");
        }
        this.amount = amount;
    }

    private boolean isNegative(int fee) {
        return fee < 0;
    }

    public static Money zero() {
        return ZERO;
    }

    public int divide(Money baseAmount) {
        return this.amount / baseAmount.amount;
    }

    public Money change(Money money) {
        if (ZERO.equals(money)) {
            return this;
        }
        return new Money(amount % money.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

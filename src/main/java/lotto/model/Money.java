package lotto.model;

import lotto.exception.LackMoneyException;

import java.util.Objects;

public class Money {
    public static final int ZERO_VALUE = 0;
    public static final Money ZERO = Money.from(ZERO_VALUE);

    private final int money;

    private Money(final int money) {
        validate(money);

        this.money = money;
    }

    private void validate(final int money) {
        if (money < ZERO_VALUE) {
            throw new LackMoneyException("money cannot be less than " + ZERO_VALUE);
        }
    }

    public static Money from(final int payment) {
        return new Money(payment);
    }

    public Money addition(final Money anotherMoney) {
        return Money.from(money + anotherMoney.money);
    }

    public Money multiply(final int operand) {
        return Money.from(money * operand);
    }

    public int getNumberOfPurchases(final Money price) {
        return this.money / price.money;
    }

    public double earningRate(final Money payment) {
        return (double) this.money / payment.money;
    }

    public int toInt() {
        return money;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        final Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    @Override
    public String toString() {
        return String.valueOf(this.money);
    }
}

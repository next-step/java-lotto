package lotto.model;

import lotto.exception.LackMoneyException;

import java.util.Objects;

import static lotto.model.LottoShop.LOTTO_PRICE;

public class Money {
    public static final int ZERO_VALUE = 0;
    public static final Money ZERO = Money.from(ZERO_VALUE);

    private final int money;

    private Money(final int money) {
        this.money = money;
    }

    public static Money from(final int payment) {
        validate(payment);
        return new Money(payment);
    }

    public static Money convert(final int lottoCount) {
        validate(lottoCount);
        return new Money(lottoCount * LOTTO_PRICE);
    }

    private static void validate(final int money) {
        if (money < ZERO_VALUE) {
            throw new LackMoneyException("money cannot be less than " + ZERO_VALUE);
        }
    }

    public Money addition(final Money anotherMoney) {
        return Money.from(this.money + anotherMoney.money);
    }

    public Money subtraction(final Money anotherMoney) {
        return Money.from(this.money - anotherMoney.money);
    }

    public Money multiply(final int operand) {
        return Money.from(this.money * operand);
    }

    public int getNumberOfPurchases() {
        return this.money / LOTTO_PRICE;
    }

    public double earningRate(final Money payment) {
        return (double) this.money / payment.money;
    }

    public int toInt() {
        return money;
    }

    public boolean isLackMoney(final int lottoCount) {
        return this.money < lottoCount * LOTTO_PRICE;
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

package Lotto.domain;

import java.util.Objects;

public class Money {
    private static final int LOTTO_PRICE = 1_000;

    private final int amount;

    private Money(final int amount) {
        validateMoney(amount);
        this.amount = amount;
    }

    public static Money from(final int amount) {
        return new Money(amount);
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    private void validateMoney(final int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("Amount of money must be more than ₩1000");
        }
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

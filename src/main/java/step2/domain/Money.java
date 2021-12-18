package step2.domain;

import step2.dto.WinningRate;
import step2.exception.InvalidMoneyException;

import java.util.Objects;

public class Money {
    private static final int ZERO = 0;

    private final long amount;

    public Money(long price) {
        validMoneyOrElseThrow(price);

        this.amount = price;
    }

    public Money() {
        this(ZERO);
    }

    public Money addMoney(Money otherMoney) {
        return new Money(this.amount + otherMoney.amount);
    }

    public WinningRate calculatePercent(Money otherMoney) {
        if (otherMoney.isZero()) {
            return new WinningRate(ZERO);
        }

        return new WinningRate(this.amount / (float) otherMoney.amount);
    }

    private boolean isZero() {
        return this.amount == ZERO;
    }

    public long dividedAmount(int basis) {
        return this.amount / basis;
    }

    public boolean lessThanPrice(long price) {
        return this.amount < price;
    }

    public long getAmount() {
        return amount;
    }

    private void validMoneyOrElseThrow(long price) {
        if (price < ZERO) {
            throw new InvalidMoneyException(price);
        }
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

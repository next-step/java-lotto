package lotto.domain;

import java.util.Objects;

public class Money {
    private final static int NO_MONEY = 0;
    private final long amount;

    public Money(long amount) {
        validate(amount);
        this.amount = amount;
    }

    public static Money from(long amount) {
        return new Money(amount);
    }

    private void validate(long amount) {
        if (amount < NO_MONEY) {
            throw new RuntimeException("금액은 " + NO_MONEY + "원 이상이어야 합니다.");
        }
    }

    public Money multiply(int number) {
        return Money.from(amount * number);
    }

    public long amount() {
        return amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Money money = (Money) object;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

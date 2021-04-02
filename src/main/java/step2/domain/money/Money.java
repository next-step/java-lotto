package step2.domain.money;

import step2.exception.InvalidNumberInputException;

import java.util.Objects;

public final class Money {

    private static final int ZERO = 0;

    private final int money;

    private Money(int money) {
        validate(money);
        this.money = money;
    }

    public static final Money valueOf(int money) {
        return new Money(money);
    }

    private final void validate(int money) {
        if (isOutOfBounds(money)) {
            throw new InvalidNumberInputException();
        }
    }

    private static final boolean isOutOfBounds(int money) {
        return money < ZERO;
    }

    public final int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}

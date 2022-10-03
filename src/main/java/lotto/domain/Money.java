package lotto.domain;

import java.util.Objects;

public class Money {
    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "돈의 액수는 음수가 될 수 없습니다.";
    public static final Money ZERO = new Money(0);

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public Money plus(Money other) {
        return new Money(money + other.money);
    }

    public Money minus(Money other) {
        return new Money(money - other.money);
    }

    public Money times(int times) {
        return new Money(money * times);
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return money >= other.money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
    }

    public int getValue() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money1 = (Money)o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

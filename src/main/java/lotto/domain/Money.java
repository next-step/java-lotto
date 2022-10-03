package lotto.domain;

import java.util.Objects;

public class Money {
    private static final String NEGATIVE_AMOUNT_EXCEPTION_MESSAGE = "돈의 액수는 음수가 될 수 없습니다.";

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public Money minus(Money other) {
        return new Money(money - other.money);
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return money >= other.money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NEGATIVE_AMOUNT_EXCEPTION_MESSAGE);
        }
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

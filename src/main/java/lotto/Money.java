package lotto;

import java.util.Objects;

public class Money {
    public static final int ZERO = 0;
    private final int money;

    public Money() {
        this(ZERO);
    }

    public Money(int money) {
        isGreaterThanEqualToZero(money);

        this.money = money;
    }

    private void isGreaterThanEqualToZero(int money) {
        if (money >= ZERO) {
            return;
        }

        throw new IllegalArgumentException("돈은 음수일 수 없습니다.");
    }

    public int quotient(Money unitPrice) {
        if (unitPrice.money == ZERO) {
            throw new IllegalArgumentException("로또 가격은 0이 될 수 없습니다.");
        }

        return this.money / unitPrice.money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money other = (Money) o;
        return money == other.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

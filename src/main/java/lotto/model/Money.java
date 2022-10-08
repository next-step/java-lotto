package lotto.model;

import java.util.Objects;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

package lotto.domain;

import java.util.Objects;

public class Money {
    private final int money;

    public Money(int money) {
        validatePositive(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 양의 정수만 입력 가능 합니다.");
        }
    }

    public Money plus(Money money2) {
        return new Money(this.money + money2.getMoney());
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

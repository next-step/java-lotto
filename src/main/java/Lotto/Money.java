package Lotto;

import java.util.Objects;

public class Money {

    private int money;

    public static final int MONEY_UNIT = 1000;
    public static final int MONEY_DIVIDE_REMAINDER_ZERO = 0;

    public Money(int money) {
        if (money % MONEY_UNIT != MONEY_DIVIDE_REMAINDER_ZERO) {
            throw new IllegalArgumentException("금액은 천원단위로 입력해주세요.");
        }
        this.money = money;

    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int getMoney() {
        return this.money;
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

    public int getUnit() {
        return this.money / MONEY_UNIT;
    }
}

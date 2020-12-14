package lotto;

import java.util.Objects;

public class Money {

    public static final String NOT_ENOUGH_MONEY_ERROR = "금액이 부족합니다. 로또를 구매할 수 없습니다.";
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR);
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

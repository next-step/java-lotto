package lotto.domain;

import java.util.Objects;

public class Money {

    private static final String MONEY_UNAVAILABLE_PURCHAGE_LOTTO_ERROR_MESSAGE = "로또 게임을 진행하려면 로또 가격보다 많은 돈을 넣어야 한다.";

    private final int money;

    public Money(int money) {
        checkAvailableForPurchaseLotto(money);

        this.money = money;
    }

    public Money(int money, int useMoney) {
        this.money = money - useMoney;
    }

    private void checkAvailableForPurchaseLotto(int money) {
        if (money / Lotto.LOTTO_PRICE == 0) {
            throw new IllegalArgumentException("MONEY_UNAVAILABLE_PURCHAGE_LOTTO_ERROR_MESSAGE");
        }
    }

    public Money useMoney(int useMoney) {
        return new Money(money, useMoney);
    }

    public int calculatePurchaseCount(int price) {
        return money / price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}

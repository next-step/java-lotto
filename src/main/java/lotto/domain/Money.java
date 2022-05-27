package lotto.domain;

import java.util.Objects;

public class Money {
    private static final int EACH_PRICE = 1000;
    private static final int MIN_MONEY = 0;

    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException("[ERROR] 0이상의 Money만 생성할 수 있습니다.");
        }
    }

    public double profitRate(Money price) {
        if (price.money == MIN_MONEY) {
            throw new IllegalArgumentException("[ERROR] 0원을 기준으로 수익률을 계산할 수 없습니다.");
        }
        return money / (double) price.money;
    }

    public Money excludeManualPurchase(int manualPurchaseCount) {
        return new Money(money - EACH_PRICE * manualPurchaseCount);
    }

    public int purchaseCount() {
        return money / EACH_PRICE;
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

package lotto.domain;

import java.util.Objects;

public class Money {
    public static final int MONEY_UNIT = 1000;
    public static final int MINIMUM_MONEY = 1000;

    private final int money;

    public Money(final int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("금액은 최소 " + MINIMUM_MONEY + "원 이상이어야 합니다.");
        }

        if (money % MONEY_UNIT > 0) {
            throw new IllegalArgumentException("금액은 " + MONEY_UNIT + "단위의 금액이여야 합니다.");
        }

        this.money = money;
    }

    public int calculatePurchases(final int unitPrice) {
        return money / unitPrice;
    }

    public double calculateRate(final long gain) {
        return (double) gain / money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Money m = (Money) obj;
        return money == m.money;
    }
}

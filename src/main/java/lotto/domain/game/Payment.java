package lotto.domain.game;

import java.util.Objects;

public final class Payment {

    private final int money;

    public Payment(final int value) {
        validateRange(value);
        money = value;
    }

    private void validateRange(final int value) {
        if (value < Lotto.PRICE) {
            throw new IllegalArgumentException("구입 금액이 부족합니다");
        }
    }

    public int calculateBuyCount(int count) {
        return (money - (count * Lotto.PRICE)) / Lotto.PRICE;
    }

    public double calculateProfitRate(double profit) {
        return Math.round(profit / money * 100) / 100.0;
    }

    public boolean isBuy(int count) {
        return ((money - (count * Lotto.PRICE)) >= 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return money == payment.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

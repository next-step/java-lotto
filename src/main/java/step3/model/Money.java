package step3.model;

import java.util.Objects;
import step3.exception.MoneyRangeNegativeException;

public class Money {

    public static final long MIN = 0L;
    private static final long LOTTO_PRICE = 1000L;

    public static Money fromLottoBundleSize(int bundleSize) {
        return new Money(LOTTO_PRICE * bundleSize);
    }

    private long money;

    public Money(long money) {
        checkPositive(money);
        this.money = money;
    }

    private void checkPositive(long money) {
        if (money < MIN) {
            throw new MoneyRangeNegativeException(money);
        }
    }

    public boolean canPurchase() {
        return money >= LOTTO_PRICE;
    }

    public void purchase() {
        money -= LOTTO_PRICE;
    }

    public boolean ableToYield() {
        return money != MIN;
    }

    public long won() {
        return money;
    }

    public void add(long money) {
        this.money += money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(Money.class)) {
            return false;
        }
        Money other = (Money) o;
        return money == other.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

package step3.model;

import step3.exception.MoneyRangeNegativeException;

public class Money {

    private static final long LOTTO_PRICE = 1000L;
    private static final long MIN = 0L;

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

    public boolean isUnableToYield() {
        return money == MIN;
    }

    public long won() {
        return money;
    }

    public void add(long money) {
        this.money += money;
    }
}

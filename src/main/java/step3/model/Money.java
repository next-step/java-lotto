package step3.model;

public class Money {

    private static final long LOTTO_PRICE = 1000L;
    private static final String RANGE_VIOLATION_ERROR_MESSAGE = "돈은 양수여야 합니다";
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
            throw new IllegalArgumentException(RANGE_VIOLATION_ERROR_MESSAGE);
        }
    }

    public boolean canPurchase() {
        return money >= LOTTO_PRICE;
    }

    public void purchase() {
        money -= LOTTO_PRICE;
    }

    public boolean isUnableToYield() {
        return money == 0;
    }

    public long won() {
        return money;
    }

    public void add(long money) {
        this.money += money;
    }
}

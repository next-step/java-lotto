package lotto;

public class Money {

    private static final int DEFAULT_BUY_COUNT = 0;
    private static final int DEFAULT_MONEY = 0;

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public boolean isZero() {
        return money == DEFAULT_MONEY;
    }

    public long countCanBuy(Money unitPrice) {
        if (unitPrice.isZero()) {
            return DEFAULT_BUY_COUNT;
        }

        return money / unitPrice.money;
    }

    public Money multiply(int times) {
        return new Money(times * money);
    }

    public double calculateProfit(long compareMoney) {
        if (compareMoney == 0) {
            return 0;
        }

        return (double) compareMoney / money;
    }
}

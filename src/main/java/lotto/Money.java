package lotto;

public class Money {

    private static final int DEFAULT_BUY_COUNT = 0;
    private static final int DEFAULT_MONEY = 0;

    private long money;

    public Money(long money) {
        this.money = money;
    }

    public Money() {
        this.money = DEFAULT_MONEY;
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

    public void add(long otherMoney) {
        money = money + otherMoney;
    }

    public double divide(Money base) {
        if (base.isZero()) {
            return DEFAULT_MONEY;
        }

        return (double) money / base.money;
    }

    public double calculateProfit(Money compareMoney) {
        return divide(compareMoney);
    }
}

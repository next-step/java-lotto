package lotto.vo;

public class Money {
    public static final long MIN_MONEY = 0;

    private final long amount;

    public Money(long amount) {
        if (isMoneyValue(amount)) {
            throw new IllegalArgumentException("Money must be positive");
        }

        this.amount = amount;
    }

    private boolean isMoneyValue(long amount) {
        return amount < MIN_MONEY;
    }

    public long getAmount() {
        return this.amount;
    }

    public boolean isEqualTo(Money target) {
        return this.amount == target.amount;
    }

    public boolean isLargerThan(Money target) {
        return target.amount < this.amount;
    }

    public Money multiply(long i) {
        return new Money(this.amount * i);
    }
}

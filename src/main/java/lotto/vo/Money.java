package lotto.vo;

public class Money {
    public static final long MIN_MONEY = 1;

    private final long amount;

    public Money(long amount) {
        if (isMoneyValue(amount)) {
            throw new IllegalArgumentException("Money must be larger than zero");
        }

        this.amount = amount;
    }

    private boolean isMoneyValue(long amount) {
        return amount < MIN_MONEY;
    }


    public long getAmount() {
        return this.amount;
    }
}

package lotto.domain;

public class Money {
    private static final long LOTTO_PRICE = 1_000;

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public int buyCount() {
        return (int) (money / LOTTO_PRICE);
    }

    public double rateOfReturn(long getTotal) {
        return Math.round((double) (getTotal / money) * 100) / 100.0;
    }
}

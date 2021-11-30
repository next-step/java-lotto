package lotto.model;

public class Money {

    private static final int LOTTO_AMOUNT = 1_000;
    private static final int DECIMAL_DENOMINATOR = 100;
    private static final double DECIMAL_NUMERATOR = 100.0;

    private final int value;

    public Money(int money) {
        value = money;
    }

    public int getLottoCount() {
        return value / LOTTO_AMOUNT;
    }

    public Double calculateRatio(Money money) {
        return Math.floor(money.value / (double) value * DECIMAL_DENOMINATOR) / DECIMAL_NUMERATOR;
    }
}

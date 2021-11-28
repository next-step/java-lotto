package lotto.model;

public class Money {

    private static final int LOTTO_AMOUNT = 1_000;

    private final int value;

    public Money(int money) {
        value = money;
    }

    public int getLottoCount() {
        return value / LOTTO_AMOUNT;
    }

    public int getMoney() {
        return value;
    }
}

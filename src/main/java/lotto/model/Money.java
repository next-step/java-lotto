package lotto.model;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getBuyableLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}

package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public int countOfLotto() {
        return this.money / LOTTO_PRICE;
    }
}

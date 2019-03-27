package lotto.domain;

public class Money {
    private final int money;
    public static final int LOTTO_PRICE = 1_000;

    public Money(int money) {
        if(money < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int purchaseQuantity() {
        return money / LOTTO_PRICE;
    }
}
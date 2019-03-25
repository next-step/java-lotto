package lotto.domain;

import lotto.Utils;

public class Money {
    private final String money;
    public static final int LOTTO_PRICE = 1_000;

    public Money(String money) {
        if(Utils.toInt(money) < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public int purchaseQuantity() {
        return Utils.toInt(money) / LOTTO_PRICE;
    }
}
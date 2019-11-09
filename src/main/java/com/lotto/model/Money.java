package com.lotto.model;

public class Money {

    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int numberOfLottoPurchased() {
        return this.money / LOTTO_PRICE_PER_ONE;
    }

}

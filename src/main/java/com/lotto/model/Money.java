package com.lotto.model;

public class Money {

    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private static final String OUT_OF_MONEY = "로또를 살 수 있는 금액이 부족합니다.";
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int numberOfLottoPurchased() {
        int numberOfLotto = this.money / LOTTO_PRICE_PER_ONE;
        if (numberOfLotto < 1) {
            throw new IllegalArgumentException(OUT_OF_MONEY);
        }
        return numberOfLotto;
    }

}

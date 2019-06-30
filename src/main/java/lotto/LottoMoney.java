package lotto;

public class LottoMoney {
    private static final int MINIMUM_MONEY = 1_000;

    private int money;

    private LottoMoney(int money) {
        this.money = money;
    }

    public static LottoMoney of(int money) {
        boolean isSmallerThanMinimum = money < MINIMUM_MONEY;
        if (isSmallerThanMinimum) {
            throw new IllegalStateException("the money is bigger than " + MINIMUM_MONEY);
        }
        return new LottoMoney(money);
    }

    public int value() {
        return money;
    }
}

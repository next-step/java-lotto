package lotto;

public class LottoMoney {
    private int money;

    private LottoMoney(int money) {
        this.money = money;
    }

    public static LottoMoney of(int money) {
        return new LottoMoney(money);
    }
}

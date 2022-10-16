package com.game.lotto.money;


public class Money {

    private int amount;

    public Money() {
        this(0);
    }

    public Money(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

}

package com.jaeyeonling.lotto.domain;

public class Money {

    private int money;

    Money(final int money) {
        this.money = money;
    }

    Money getBalance() {
        return new Money(money);
    }
}

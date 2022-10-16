package com.game.lotto.money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    private final static int MONEY_AMOUNT = 1_000;
    private final static int MONEY_ADD_AMOUNT = 300;

    @Test
    void get_amount() {
        Money money = new Money(MONEY_AMOUNT);
        assertEquals(MONEY_AMOUNT, money.getAmount());
    }

    @Test
    void add_amount() {
        Money money = new Money(MONEY_AMOUNT);
        money.addAmount(MONEY_ADD_AMOUNT);
        assertEquals(MONEY_AMOUNT + MONEY_ADD_AMOUNT, money.getAmount());
    }
}
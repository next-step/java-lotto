package com.lotto.domain;

public class Deposit {

    private static final int LOTTERY_PRICE = 1_000;
    private final int amount;

    public Deposit(int amount) throws IllegalArgumentException {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int purchaseLottery() {
        return amount / LOTTERY_PRICE;
    }
}

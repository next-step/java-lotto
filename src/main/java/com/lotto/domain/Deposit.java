package com.lotto.domain;

public class Deposit {

    private static final int LOTTERY_PRICE = 1_000;
    private final int amount;

    public Deposit(int amount) throws IllegalStateException {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) throws IllegalStateException {
        if (amount < 0) {
            throw new IllegalStateException();
        }
    }

    public int purchaseLottery() {
        return amount / LOTTERY_PRICE;
    }
}

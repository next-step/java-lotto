package com.lotto.domain;

public class Deposit {

    private static final int LOTTERY_PRICE = 1_000;
    private static final int BASE_PRICE = 0;
    private final int amount;

    public Deposit(int amount) throws IllegalArgumentException {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) throws IllegalArgumentException {
        if (amount < BASE_PRICE) {
            String message = String.format("%d 이상의 값을 입력해 주세요.", BASE_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    public int purchaseLottery() {
        return amount / LOTTERY_PRICE;
    }
}

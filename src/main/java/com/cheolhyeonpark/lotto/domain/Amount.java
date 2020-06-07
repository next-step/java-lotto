package com.cheolhyeonpark.lotto.domain;

public class Amount {

    public static final int GAME_PRICE = 1_000;

    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isUnderGamePrice(amount)) {
            throw new IllegalArgumentException("Not enough money.");
        }
    }

    private boolean isUnderGamePrice(int number) {
        return number < GAME_PRICE;
    }

    public Count getAutoCount(Count manualCount) {
        return new Count(manualCount.getRemainCount(amount / GAME_PRICE));
    }

    public double getYields(int totalPrice) {
        return (double) totalPrice / amount;
    }
}

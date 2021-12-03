package edu.nextstep.camp.lotto.domain;

import java.util.Objects;

public class Budget {
    public static final int GAME_PRICE = 1000;

    private final int budget;

    private Budget(int budget) {
        this.budget = budget;
    }

    public static Budget of(int budget) {
        if (budget < GAME_PRICE) {
            throw new IllegalArgumentException("invalid input: budget must be at least 1000, but " + budget);
        }

        if (budget % GAME_PRICE != 0) {
            throw new IllegalArgumentException("invalid input: budget must be multiple of 1000, but " + budget);
        }

        return new Budget(budget);
    }

    public int budget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget1 = (Budget) o;
        return budget == budget1.budget;
    }

    @Override
    public int hashCode() {
        return Objects.hash(budget);
    }

    public int availableAmount() {
        return budget / GAME_PRICE;
    }

    public Budget purchased(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount cannot be negative, but " + amount);
        }

        if (budget < GAME_PRICE * amount) {
            throw new IllegalArgumentException("not enough money for purchasing " + amount);
        }

        return new Budget(budget - amount * GAME_PRICE);
    }
}

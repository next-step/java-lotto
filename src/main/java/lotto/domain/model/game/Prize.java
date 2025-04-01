package lotto.domain.model.game;

import java.util.Objects;

public class Prize {
    private final int amount;

    public Prize(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Prize add(final Prize other) {
        return new Prize(this.amount + other.amount);
    }

    public static Prize zero() {
        return new Prize(0);
    }

    public Prize multiply(int times) {
        return new Prize(this.amount * times);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return amount == prize.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
} 

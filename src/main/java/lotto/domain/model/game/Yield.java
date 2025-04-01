package lotto.domain.model.game;

import lotto.domain.model.lotto.PurchaseAmount;

import java.util.Objects;

public class Yield {
    private final double value;

    public Yield(final Prize totalPrize, final PurchaseAmount purchaseAmount) {
        if (purchaseAmount.getAmount() == 0) {
            this.value = 0;
            return;
        }
        this.value = (double) totalPrize.getAmount() / purchaseAmount.getAmount();
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yield yield = (Yield) o;
        return Double.compare(yield.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
} 

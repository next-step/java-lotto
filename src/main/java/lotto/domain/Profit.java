package lotto.domain;

import java.util.Objects;

public class Profit {
    private double profitRate;

    public Profit(double totalPrize, int totalCost) {
        this.profitRate = calculateRate(totalPrize,totalCost);
    }

    public double calculateRate(double totalPrize, int totalCost) {
        return Math.floor(totalPrize / totalCost * 100) / 100;
    }

    @Override
    public String toString() {
        return Double.toString(profitRate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!Double.class.isAssignableFrom(o.getClass())) return false;
        Double that = (Double) o;
        return Double.compare(profitRate, that) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(profitRate);
    }
}

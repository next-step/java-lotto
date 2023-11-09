package lotto.domain;

import java.util.Objects;

public class Revenue {
    public static final int DEFAULT_PERCENT = 1;
    private final double revenue;

    public Revenue(int basic,
                   int amount) {
        double rate = (double) basic / amount;
        this.revenue = Math.floor(rate * 100) / 100;
    }

    public Revenue(double revenue) {
        this.revenue = revenue;
    }

    public boolean isBenefit() {
        return DEFAULT_PERCENT < this.revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue1 = (Revenue) o;
        return Double.compare(revenue1.revenue, revenue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    @Override
    public String toString() {
        return String.valueOf(revenue);
    }
}

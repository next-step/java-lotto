package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class Profit {
    private static final double SCALE = 10.0;
    private static final double DECIMAL_PRECISION = 100.0;

    private final Double value;

    public Profit(double value) {
        this.value = value;
    }

    public Profit(Map<Rank, Integer> ranks, int totalCount) {
        this.value = calculateProfitRate(calculateTotalPrize(ranks), totalCount);
    }

    private long calculateTotalPrize(Map<Rank, Integer> ranks) {
        long totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : ranks.entrySet()) {
            Rank rank = entry.getKey();
            int winsCount = entry.getValue();
            totalPrize += rank.calculatePrize(winsCount);
        }

        return totalPrize;
    }

    private double calculateProfitRate(long totalPrize, int totalCount) {
        return Math.floor(totalPrize / (totalCount * SCALE)) / DECIMAL_PRECISION;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profit profit = (Profit) o;
        return Objects.equals(value, profit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

package lotto.domain;

import java.util.Map;

public class LottoEarning {
    private final int profit;
    private final double returnRate;

    public LottoEarning(Map<Rank, Integer> result, int purchasePrice) {
        this.profit = calculateTotalEarning(result);
        this.returnRate = calculateReturnRate(purchasePrice);
    }

    private int calculateTotalEarning(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private double calculateReturnRate(int purchasePrice) {
        if (purchasePrice == 0) return 0.0;
        return (double) profit / purchasePrice;
    }

    public int getProfit() {
        return profit;
    }

    public double getReturnRate() {
        return returnRate;
    }
}

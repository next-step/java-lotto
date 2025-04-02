package lotto.domain;

import java.util.Map;

public class LottoEarning {
    private final int profit;
    private final double returnRate;

    private LottoEarning(int profit, double returnRate) {
        this.profit = profit;
        this.returnRate = returnRate;
    }

    public static LottoEarning from(Map<Rank, Integer> result, int purchasePrice) {
        int profit = calculateTotalEarning(result);
        double returnRate = calculateReturnRate(profit, purchasePrice);
        return new LottoEarning(profit, returnRate);
    }

    private static int calculateTotalEarning(Map<Rank, Integer> result) {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    private static double calculateReturnRate(int profit, int purchasePrice) {
        if (purchasePrice == 0) {
            return 0.0;
        }
        return (double) profit / purchasePrice;
    }

    public int getProfit() {
        return profit;
    }

    public double getReturnRate() {
        return returnRate;
    }
}

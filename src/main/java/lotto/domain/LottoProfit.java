package lotto.domain;

import java.util.Map;

public class LottoProfit {
    private final Double profitRate;

    public LottoProfit(Map<LottoPrize, Integer> ranks, int totalCount) {
        int totalPrize = calculateTotalPrize(ranks);
        profitRate = calculateProfitRate(totalPrize, totalCount);
    }

    private int calculateTotalPrize(Map<LottoPrize, Integer> ranks) {
        int totalPrize = 0;

        for (Map.Entry<LottoPrize, Integer> entry : ranks.entrySet()) {
            LottoPrize lottoPrize = entry.getKey();
            int winsCount = entry.getValue();
            totalPrize += lottoPrize.getPrize() * winsCount;
        }

        return totalPrize;
    }

    private double calculateProfitRate(int totalPrize, int totalCount) {
        double rawProfitRate = totalPrize / (double) (totalCount * 1000);
        return Math.floor(rawProfitRate * 100) / 100.0;
    }

    public Double getProfitRate() {
        return profitRate;
    }
}

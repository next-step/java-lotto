package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> winningCountsByPrize = new HashMap<>();
    private long totalProfit = 0L;
    private double profitRate = 0.0;

    public void update(LottoPrize lottoPrize) {
        winningCountsByPrize.put(lottoPrize, winningCountsByPrize.getOrDefault(lottoPrize, 0) + 1);
        totalProfit += lottoPrize.getPrize();
    }

    public void calculateProfitRate(int purchaseAmount) {
        if (totalProfit == 0) {
            return;
        }
        profitRate = (double) totalProfit / purchaseAmount;
    }

    public Map<LottoPrize, Integer> getWinningCountsByPrize() {
        return winningCountsByPrize;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

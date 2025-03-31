package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private final Map<MatchCount, Integer> winningResult;

    public WinningResult() {
        this.winningResult = new EnumMap<>(MatchCount.class);
    }

    public int countByMatch(MatchCount matchCount) {
        return winningResult.getOrDefault(matchCount, 0);
    }

    public void add(MatchCount matchCount) {
        winningResult.put(matchCount, winningResult.getOrDefault(matchCount, 0) + 1);
    }

    public BigDecimal calculateProfitRate(int purchasePrice) {
        int profit = calculateTotalProfit();
        return calculateRate(purchasePrice, profit);
    }

    private static BigDecimal calculateRate(int purchasePrice, int profit) {
        return BigDecimal.valueOf(profit)
            .divide(BigDecimal.valueOf(purchasePrice), 2, RoundingMode.HALF_UP);
    }

    private int calculateTotalProfit() {
        int profit = 0;
        for (Map.Entry<MatchCount, Integer> entry : winningResult.entrySet()) {
            profit += (entry.getKey().getPrize() * entry.getValue());
        }
        return profit;
    }
}

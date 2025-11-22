package lotto.domain;

import java.util.Map;

public class WinningResult {
    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int getCountByRank(Rank rank) {
        return result.get(rank);
    }

    public int getTotalWinningAmount() {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getWinningAmount() * result.get(rank);
        }
        return total;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        return purchaseAmount.calculateProfitRate(getTotalWinningAmount());
    }
}

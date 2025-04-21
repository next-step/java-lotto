package model;

import java.util.Map;

public class LottoResult {
    private final int lottoPrice;
    private final Map<Rank, Integer> rankCounts;

    public LottoResult(int lottoPrice, Map<Rank, Integer> rankCounts) {
        this.lottoPrice = lottoPrice;
        this.rankCounts = rankCounts;
    }

    public int rankCount(Rank rank) {
        return rankCounts.getOrDefault(rank, 0);
    }

    public int totalPrize() {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            Rank rank = entry.getKey();
            Integer count = entry.getValue();
            totalPrize += rank.getWinningMoney() * count;
        }
        return totalPrize;
    }

    public int totalInvestment() {
        int totalCount = 0;
        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            Integer count = entry.getValue();
            totalCount += count;
        }
        return totalCount * lottoPrice;
    }
}

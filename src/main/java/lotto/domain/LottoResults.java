package lotto.domain;

import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> prizeCount;

    public LottoResults() {
        prizeCount = LottoRank.initializePrizeCount();
    }

    public void addResult(LottoRank rank) {
        prizeCount.put(rank, prizeCount.getOrDefault(rank, 0) + 1);
    }

    public int getPrizeMoney() {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : prizeCount.entrySet()) {
            totalPrize += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrize;
    }

    public int getPrizeCountByRank(LottoRank rank) {
        return prizeCount.getOrDefault(rank, 0);
    }
}

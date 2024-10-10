package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> prizeCount;

    public LottoResults() {
        prizeCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            prizeCount.put(rank, 0);
        }
    }

    public void addResult(int lottoResult) {
        LottoRank rank = LottoRank.valueOf(lottoResult);
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

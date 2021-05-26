package lotto.domain;

import java.util.Map;

import lotto.constant.LottoRank;

public class RankCounts {
    public static final int DEFAULT_COUNT = 0;
    private final Map<LottoRank, Integer> counts;

    public RankCounts(Map<LottoRank, Integer> counts) {
        this.counts = counts;
    }

    public int getWinningLottoCount(LottoRank rank) {
        return this.counts.getOrDefault(rank, DEFAULT_COUNT);
    }

    public int calculateTotalCountByRank() {
        int totalCount = DEFAULT_COUNT;
        for (LottoRank rank : counts.keySet()) {
            totalCount += this.counts.getOrDefault(rank, DEFAULT_COUNT);
        }
        return totalCount;
    }

    @Override
    public String toString() {
        return this.counts.toString();
    }
}

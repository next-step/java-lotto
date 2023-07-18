package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankWithWinningCount {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> rankWithCount;

    private RankWithWinningCount(final Map<LottoRank, Integer> rankWithCount) {
        this.rankWithCount = rankWithCount;
    }

    public RankWithWinningCount(final List<LottoRank> lottoResultRanks) {
        this.rankWithCount = new HashMap<>();

        for (final LottoRank lottoRank : lottoResultRanks) {
            this.rankWithCount.putIfAbsent(lottoRank, 0);
            this.rankWithCount.computeIfPresent(lottoRank, (rank, count) -> count + 1);
        }
    }

    public int getWinningCount(final LottoRank lottoRank) {
        return this.rankWithCount.getOrDefault(lottoRank, DEFAULT_COUNT);
    }

    public RankWithWinningCount sum(RankWithWinningCount other) {
        final Map<LottoRank, Integer> sumResult = new HashMap<>();
        for (final LottoRank lottoRank : LottoRank.values()) {
            sumResult.putIfAbsent(lottoRank, 0);
            sumResult.computeIfPresent(lottoRank,
                    (rank, count) -> count + this.getWinningCount(rank) + other.getWinningCount(rank)
            );
        }
        return new RankWithWinningCount(sumResult);
    }
}

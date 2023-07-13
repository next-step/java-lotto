package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankWithWinningCount {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> rankWithCount;

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
}

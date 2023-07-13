package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankWithWinningCount {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoRank, Integer> rankWithCount;

    public RankWithWinningCount(final List<LottoRank> lottoResultRanks) {
        this.rankWithCount = new HashMap<>();

        for (LottoRank lottoRank : lottoResultRanks) {
            this.rankWithCount.put(lottoRank,
                    this.rankWithCount.getOrDefault(lottoRank, DEFAULT_COUNT) + 1);
        }
    }

    public int getWinningCount(final LottoRank lottoRank) {
        return this.rankWithCount.getOrDefault(lottoRank, DEFAULT_COUNT);
    }
}

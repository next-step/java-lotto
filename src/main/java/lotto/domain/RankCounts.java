package lotto.domain;

import java.util.Map;

public class RankCounts {

    private final Map<LottoRank, Integer> rankCounts;

    public RankCounts(final Map<LottoRank, Integer> rankCounts) {
        this.rankCounts = rankCounts;
    }

    public Map<LottoRank, Integer> get() {
        return this.rankCounts;
    }
}

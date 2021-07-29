package lotto.domain;

import java.util.Map;

public final class LottoStatistics {
    private final Map<LottoRank, Integer> rank;

    public LottoStatistics(Map<LottoRank, Integer> rank) {
        this.rank = rank;
    }

    public Money yield() {
        return null;
    }

    public int count(LottoRank lottoRank) {
        return 0;
    }
}

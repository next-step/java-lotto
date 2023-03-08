package lotto.ui;

import lotto.domain.enums.LottoRank;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> ranks;

    public LottoResult(Map<LottoRank, Integer> ranks) {
        this.ranks = ranks;
    }

    public int findHitCount(final LottoRank rank) {
        return ranks.getOrDefault(rank, 0);
    }
}

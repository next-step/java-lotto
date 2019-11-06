package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankGroup {

    private final Map<LottoRank, Long> rankGroup;

    public LottoRankGroup(Map<LottoRank, Long> rankGroup) {
        this.rankGroup = rankGroup;
    }

    public Map<LottoRank, Long> getValue() {
        return new HashMap<>(rankGroup);
    }
}

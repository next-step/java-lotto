package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankGroup {

    private final Map<LottoRank, Long> rankGroup;

    public LottoRankGroup(Map<LottoRank, Long> rankGroup) {
        this.rankGroup = rankGroup;
    }

    public Long getRankCount(LottoRank lottoRank) {
        return rankGroup.get(lottoRank);
    }

    public long getTotalProfit() {
        return rankGroup
                .entrySet()
                .stream()
                .map(e -> e.getKey().getWinning() * e.getValue())
                .reduce(0L, Long::sum);
    }

    public Map<LottoRank, Long> getValue() {
        return new HashMap<>(rankGroup);
    }
}

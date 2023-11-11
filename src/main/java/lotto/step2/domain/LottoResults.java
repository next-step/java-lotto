package lotto.step2.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResults {
    private final Map<LottoRank, Integer> rankResult;

    public LottoResults() {
        rankResult = new EnumMap<>(LottoRank.class);
    }

    public int getCount(final LottoRank lottoRank) {
        return rankResult.getOrDefault(lottoRank, 0);
    }

    public void incrementRankCount(final LottoRank lottoRank) {
        rankResult.put(lottoRank, getCount(lottoRank) + 1);
    }
}

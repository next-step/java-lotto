package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankWithWinningCount {

    private static final int DEFAULT_COUNT = 0;

    private final Map<LottoRule, Integer> rankWithCount;

    public RankWithWinningCount(final List<LottoRule> lottoResults) {
        this.rankWithCount = new HashMap<>();

        for (LottoRule lottoResult : lottoResults) {
            this.rankWithCount.put(lottoResult,
                    this.rankWithCount.getOrDefault(lottoResult, DEFAULT_COUNT) + 1);
        }
    }

    public int getWinningCount(final LottoRule lottoRule) {
        return this.rankWithCount.getOrDefault(lottoRule, DEFAULT_COUNT);
    }
}

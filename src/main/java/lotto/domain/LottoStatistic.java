package lotto.domain;

import java.util.Map;

public final class LottoStatistic {

    private Map<LottoRank, Integer> statistic;

    public LottoStatistic(final Map<LottoRank, Integer> statistic) {
        this.statistic = statistic;
    }

    public Integer getRankCount(final LottoRank lottoRank) {
        return statistic.getOrDefault(lottoRank, 0);
    }
}

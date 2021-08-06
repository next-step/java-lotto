package lotto.domain;

import java.util.Map;

public class LottoStatistic {

    private Map<LottoRank, Integer> statistic;

    public LottoStatistic(Map<LottoRank, Integer> statistic) {
        this.statistic = statistic;
    }

    public Integer getRankCount(LottoRank lottoRank) {
        return statistic.getOrDefault(lottoRank, 0);
    }
}

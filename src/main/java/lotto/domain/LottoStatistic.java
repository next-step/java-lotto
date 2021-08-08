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

    public double getProfitRate(double amount) {
        double totalSum = 0;
        for (LottoRank lottoRank : statistic.keySet()) {
            totalSum += lottoRank.getAmount() * statistic.get(lottoRank);
        }
        return totalSum / amount;
    }
}

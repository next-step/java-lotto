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

    public String getProfitRate(double amount) {
        double totalSum = 0;
        for (LottoRank lottoRank : statistic.keySet()) {
            totalSum = sum(totalSum, lottoRank);
        }
        return String.format("%.2f", totalSum / amount);
    }

    private double sum(double totalSum, LottoRank lottoRank) {
        Integer matchingCount = statistic.get(lottoRank);
        if (matchingCount > 0) {
            totalSum += lottoRank.getAmount() * matchingCount;
        }
        return totalSum;
    }
}

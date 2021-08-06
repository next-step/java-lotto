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

    // 수익률 계산
    public String getProfitRate(double amount) {
        double totalSum = 0;
        for (Map.Entry<LottoRank, Integer> entry : statistic.entrySet()) {
            if ( entry.getValue() > 0 ) {
                totalSum += entry.getKey().AMOUNT;
            }
        }
        return String.format("%.2f", totalSum / amount);
    }
}

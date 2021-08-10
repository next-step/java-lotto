package lotto.domain;

import java.util.List;

public final class LottoStatistic {

    private final List<LottoRank> statistic;

    public LottoStatistic(final List<LottoRank> statistic) {
        this.statistic = statistic;
    }

    public int getRankCount(final LottoRank lottoRank) {
        return (int) statistic.stream()
                .filter(obj -> obj.equals(lottoRank))
                .count();
    }

    public double getProfitRate(final double amount) {
        double totalSum = statistic.stream()
                .mapToDouble(LottoRank::getAmount)
                .reduce(0, Double::sum);

        return totalSum / amount;
    }
}

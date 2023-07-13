package lotto.model.domain;

import java.util.Map;

public final class LottoResult {

    public static final int DEFAULT_VALUE = 0;

    private final Map<Rank, Integer> lottoResultStatistics;
    private final double profitRate;

    public LottoResult(final RankResults ranks, final LottoMoney lottoMoney) {
        this.lottoResultStatistics = ranks.getRanksCounts();
        this.profitRate = calculateProfitRate(lottoMoney);
    }

    private double calculateProfitRate(final LottoMoney lottoMoney) {
        long totalPrize = lottoResultStatistics.entrySet().stream()
                .mapToLong(entry -> Rank.getTotalPrize(entry.getKey(), entry.getValue()))
                .sum();
        return totalPrize / lottoMoney.getTotalSpentMoney();
    }

    public int getCount(final Rank rank) {
        return lottoResultStatistics.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double getProfitRate() {
        return profitRate;
    }
}

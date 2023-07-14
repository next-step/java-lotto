package lotto.model.domain;

import java.util.Map;

public final class LottoResult {

    private static final long DEFAULT_VALUE = 0L;

    private final Map<Rank, Long> lottoResultStatistics;
    private final ProfitRate profitRate;

    public LottoResult(final RankResults ranks, final LottoMoney lottoMoney) {
        this.lottoResultStatistics = ranks.getRanksCounts();
        this.profitRate = calculateProfitRate(lottoMoney);
    }

    private ProfitRate calculateProfitRate(final LottoMoney lottoMoney) {
        long totalPrize = lottoResultStatistics.entrySet().stream()
                .mapToLong(entry -> Rank.getTotalPrize(entry.getKey(), entry.getValue()))
                .sum();
        return new ProfitRate(totalPrize, lottoMoney.getTotalSpentMoney());
    }

    public long getCount(final Rank rank) {
        return lottoResultStatistics.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double getProfitRate() {
        return profitRate.getProfitRate();
    }
}

package lotto.model.domain;

import java.util.EnumMap;
import java.util.List;

public final class LottoResult {

    public static final int DEFAULT_VALUE = 0;

    private final EnumMap<Rank, Integer> lottoResultStatistics;
    private final double profitRate;

    public LottoResult(final List<Rank> ranks, final LottoMoney lottoMoney) {
        this.lottoResultStatistics = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> this.lottoResultStatistics.put(
                rank,
                this.lottoResultStatistics.getOrDefault(rank, DEFAULT_VALUE) + 1
        ));
        this.profitRate = calculateProfitRate(lottoMoney);
    }

    private double calculateProfitRate(final LottoMoney lottoMoney) {
        long totalPrize = lottoResultStatistics.entrySet().stream()
                .mapToLong(entry -> Rank.getTotalPrize(entry.getKey(), entry.getValue()))
                .sum();
        return totalPrize / lottoMoney.getSpentMoney();
    }

    public int getCount(final Rank rank) {
        return lottoResultStatistics.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double getProfitRate() {
        return profitRate;
    }
}

package lotto.model.domain;

import java.util.EnumMap;
import java.util.List;

public final class LottoResult {

    public static final int DEFAULT_VALUE = 0;

    private final EnumMap<Rank, Integer> lottoResult;
    private final double profitRate;

    private LottoResult(final List<Rank> ranks, final LottoMoney purchase) {
        this.lottoResult = new EnumMap<>(Rank.class);
        ranks.forEach(rank -> this.lottoResult.put(
                rank,
                this.lottoResult.getOrDefault(rank, DEFAULT_VALUE) + 1
        ));
        this.profitRate = calculateProfitRate(purchase);
    }

    public static LottoResult of(final List<Rank> ranks, final LottoMoney purchase) {
        return new LottoResult(ranks, purchase);
    }

    private double calculateProfitRate(final LottoMoney purchase) {
        final LottoMoney totalPrize = LottoMoney.valueOf(calculateTotalPrize());
        return totalPrize.rate(purchase);
    }

    private long calculateTotalPrize() {
        return lottoResult.entrySet()
                .stream()
                .mapToLong(entry -> Rank.getTotalPrize(entry.getKey(), entry.getValue()))
                .sum();
    }

    public int getCount(final Rank rank) {
        return lottoResult.getOrDefault(rank, DEFAULT_VALUE);
    }

    public double getProfitRate() {
        return profitRate;
    }
}

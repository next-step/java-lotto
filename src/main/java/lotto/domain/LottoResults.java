package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    public static final Count DEFAULT_COUNT = new Count(0);
    private static final Money DEFAULT_MONEY = new Money(0);
    private static final Money LOTTO_PRICE = new Money(1000);

    private final Map<LottoRank, Count> lottoResults;
    private final Profit profitRate;

    public LottoResults(List<LottoRank> lottoRanks) {
        lottoResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : lottoRanks) {
            lottoResults.put(
                    rank,
                    Count.sum(
                            lottoResults.getOrDefault(rank, DEFAULT_COUNT),
                            new Count(1))
            );
        }

        Money principal = countLottos().multiply(LOTTO_PRICE);
        this.profitRate =  Money.calculateProfitRate(sumPrice(), principal);
    }

    public Map<LottoRank, Count> getLottoResults() {
        return lottoResults;
    }

    public Profit getProfitRate() {
        return profitRate;
    }

    private Money sumPrice() {
        return lottoResults.entrySet()
                .stream()
                .map(entry -> sumEachRank(entry.getKey(), entry.getValue()))
                .reduce(Money::sum)
                .orElse(DEFAULT_MONEY);
    }

    private Money sumEachRank(LottoRank rank, Count count) {
        return count.multiply(rank.getPrice());
    }

    private Count countLottos() {
        return lottoResults.values()
                .stream()
                .reduce(Count::sum)
                .orElse(DEFAULT_COUNT);
    }
}

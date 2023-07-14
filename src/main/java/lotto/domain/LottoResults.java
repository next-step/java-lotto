package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private static final long DEFAULT_VALUE = 0L;
    private static final Money LOTTO_PRICE = new Money(1000);

    private final Map<LottoRank, Long> lottoResults;
    private final Profit profitRate;

    public LottoResults(List<LottoRank> lottoRanks) {
        lottoResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : lottoRanks) {
            lottoResults.put(rank, lottoResults.getOrDefault(rank, DEFAULT_VALUE) + 1L);
        }

        Money principal = LOTTO_PRICE.multiply(countLottos());
        this.profitRate =  Money.calculateProfitRate(sumPrice(), principal);
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public Profit getProfitRate() {
        return profitRate;
    }

    private Money sumPrice() {
        return new Money(
                lottoResults.entrySet()
                        .stream()
                        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                        .sum()
        );
    }

    private long countLottos() {
        return lottoResults.values()
                .stream()
                .mapToLong(l -> l)
                .sum();
    }
}

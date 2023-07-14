package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    public static final long DEFAULT_VALUE = 0L;
    private final Map<LottoRank, Long> lottoResults;

    public LottoResults(List<LottoRank> lottoRanks) {
        lottoResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : lottoRanks) {
            lottoResults.put(rank, lottoResults.getOrDefault(rank, DEFAULT_VALUE) + 1L);
        }
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
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

    public Profit profitRate() {
        return new Profit(sumPrice(), countLottos());
    }
}

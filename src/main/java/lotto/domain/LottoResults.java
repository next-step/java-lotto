package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    private final Map<LottoRank, Long> lottoResults;

    public LottoResults(List<LottoRank> lottoRanks) {
        lottoResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : lottoRanks) {
            lottoResults.put(rank, 1L);
        }
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public Money sumPrice() {
        return new Money(
                lottoResults.entrySet()
                        .stream()
                        .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                        .sum()
        );
    }
}

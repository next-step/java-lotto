package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {

    private static final long DEFAULT_VALUE = 0L;
    private final Map<LottoRank, Long> lottoResults;

    public LottoResults() {
        lottoResults = new EnumMap<>(LottoRank.class);
    }

    public Map<LottoRank, Long> getLottoResults() {
        return lottoResults;
    }

    public void add(LottoRank lottoRank, long count) {
        lottoResults.put(lottoRank, lottoResults.getOrDefault(lottoRank, DEFAULT_VALUE) + count);
    }

    public Money sumTotalPrize() {
        long sum = DEFAULT_VALUE;
        for (LottoRank lottoRank : lottoResults.keySet()) {
            sum += lottoRank.sumPrize(lottoResults.getOrDefault(lottoRank, DEFAULT_VALUE));
        }
        return new Money(sum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(lottoResults, that.lottoResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResults);
    }
}

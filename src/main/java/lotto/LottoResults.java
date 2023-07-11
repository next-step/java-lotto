package lotto;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class LottoResults {

    private static final long DEFAULT_VALUE = 0L;
    private final Map<LottoRank, Long> lottoResults;

    public LottoResults() {
        lottoResults = new EnumMap<>(LottoRank.class);
    }

    public void add(LottoRank lottoRank, long count) {
        lottoResults.put(lottoRank, lottoResults.getOrDefault(lottoRank, DEFAULT_VALUE) + count);
    }

    public long sumPrice() {
        long sum = DEFAULT_VALUE;
        for(LottoRank lottoRank : lottoResults.keySet()) {
            sum += lottoResults.getOrDefault(lottoRank, DEFAULT_VALUE) * lottoRank.getPrice();
        }
        return sum;
    }

    public long get(LottoRank lottoRank) {
        return lottoResults.getOrDefault(lottoRank, DEFAULT_VALUE);
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

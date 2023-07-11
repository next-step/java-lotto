package lotto;

import java.util.EnumMap;
import java.util.Map;

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
}

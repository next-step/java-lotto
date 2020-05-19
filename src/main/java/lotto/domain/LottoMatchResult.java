package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResult {

    private final Map<LottoMatch, Long> lottoMatchCountMap;
    private final int totalPrice;

    public LottoMatchResult(Map<LottoMatch, Long> map, int totalPrice) {
        this.lottoMatchCountMap = map;
        this.totalPrice = totalPrice;
    }

    public long get(LottoMatch lottoMatch) {
        return lottoMatchCountMap.getOrDefault(lottoMatch, 0L);
    }

    public double computeProfitRate() {
        long sum = lottoMatchCountMap.keySet().stream()
            .map(this::computeMatchAmount)
            .collect(Collectors.summingLong(Long::longValue));

        return 1.0 * sum / totalPrice;
    }

    private Long computeMatchAmount(LottoMatch lottoMatch) {
        return lottoMatch.getAmount() * lottoMatchCountMap.get(lottoMatch);
    }
}

package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMatchResult {

    private final Map<LottoMatch, Integer> lottoMatchCountMap;
    private final int totalPrice;

    public LottoMatchResult(int totalPrice) {
        this.lottoMatchCountMap = new HashMap<>();
        this.totalPrice = totalPrice;
    }

    void increment(LottoMatch lottoMatch) {
        lottoMatchCountMap.put(lottoMatch, lottoMatchCountMap.getOrDefault(lottoMatch, 0) + 1);
    }

    public int get(LottoMatch lottoMatch) {
        return lottoMatchCountMap.getOrDefault(lottoMatch, 0);
    }

    public double computeProfitRate() {
        int sum = lottoMatchCountMap.keySet().stream()
            .map(this::computeMatchAmount)
            .collect(Collectors.summingInt(Integer::intValue));

        return 1.0 * sum / totalPrice;
    }

    private int computeMatchAmount(LottoMatch lottoMatch) {
        return lottoMatch.getAmount() * lottoMatchCountMap.get(lottoMatch);
    }
}

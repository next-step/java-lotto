package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Long> result;

    public LottoResult(Map<LottoRank, Long> result) {
        this.result = result;
    }

    public Money calculateTotalPrize() {
        Long totalPrize = result.keySet()
            .stream()
            .mapToLong(key -> key.getPrize() * result.get(key))
            .sum();
        return new Money(totalPrize);
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }
}

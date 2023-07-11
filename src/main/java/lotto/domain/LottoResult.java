package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Long> result;

    public LottoResult(Map<LottoRank, Long> result) {
        this.result = result;
    }

    public Long calculateTotalPrize() {
        return result.keySet()
            .stream()
            .mapToLong(key -> key.getPrize() * result.get(key))
            .sum();
    }

    public Map<LottoRank, Long> getResult() {
        return result;
    }
}

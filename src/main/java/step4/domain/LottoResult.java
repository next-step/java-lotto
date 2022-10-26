package step4.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Prize, Long> results;

    public LottoResult(Map<Prize, Long> results) {
        this.results = results;
    }

    public int getResultCount(Prize prize) {
        return this.results.getOrDefault(prize, 0L).intValue();
    }
}

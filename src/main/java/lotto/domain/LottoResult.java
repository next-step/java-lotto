package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> result;

    public LottoResult(Map<Prize, Integer> result) {
        this.result = result;
    }

    public int prizeCount(Prize prize) {
        return result.getOrDefault(prize, 0);
    }

}

package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Integer, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(int matchCount) {
        if (result.containsKey(matchCount)) {
            result.put(matchCount, result.get(matchCount) + 1);
        } else {
            result.put(matchCount, 1);
        }
    }

    public int numOf(int targetNumber) {
        return result.get(targetNumber);
    }
}

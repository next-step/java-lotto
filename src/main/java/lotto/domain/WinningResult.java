package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class WinningResult {

    private final Map<RankLotto, Integer> result;

    public WinningResult(Map<RankLotto, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

    public int totalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().winningMoney() * entry.getValue())
                .sum();
    }
}

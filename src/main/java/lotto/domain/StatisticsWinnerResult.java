package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class StatisticsWinnerResult {

    private final Map<RankLotto, Integer> result;

    public StatisticsWinnerResult(Map<RankLotto, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

    private int totalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().calculateWinningMoney(entry.getValue()))
                .sum();
    }

    public double rateOfReturn(int money) {
        return (double) totalPrize() / money;
    }
}

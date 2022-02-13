package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class WinningResult {

    private final Map<Rank, Integer> result;

    public WinningResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public double calculateProfitRate(int buyCash) {
        long prizeMoney = calculatePrizeMoney();
        return (double) prizeMoney / buyCash;
    }

    public long calculatePrizeMoney() {
        long prizeMoney = 0;
        for (Rank rank : result.keySet()) {
            prizeMoney += result.get(rank) * rank.getPrizeMoney();
        }
        return prizeMoney;
    }

    public Map<Rank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }
}

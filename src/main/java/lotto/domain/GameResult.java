package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class GameResult {
    private final Map<Rank, Integer> resultStats;
    private final double returnRate;

    public GameResult(Map<Rank, Integer> resultStats, double returnRate) {
        this.resultStats = Collections.unmodifiableMap(new EnumMap<>(resultStats));
        this.returnRate = returnRate;
    }

    public Map<Rank, Integer> getResultStats() {
        return resultStats;
    }

    public double getReturnRate() {
        return returnRate;
    }
}

package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> statistics;

    public Statistics(Lottos lottos, WinningNumber winningNumber) {
        statistics = new HashMap<>();
    }

    public double yield() {
        return 0.0;
    }

    public Boolean isLoss() {
        return true;
    }
}

package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<RANK, Integer> winningStats;
    private final double earningRate;

    public Statistics(Map<RANK, Integer> winningStats, double earningRate) {
        this.winningStats = winningStats;
        this.earningRate = earningRate;
    }

    public Map<RANK, Integer> getWinningStats() {
        return new HashMap<>(winningStats);
    }

    public double getEarningRate() {
        return earningRate;
    }
}

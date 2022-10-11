package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<WinningPrize, Integer> winningStats;
    private final double earningRate;

    public Statistics(Map<WinningPrize, Integer> winningStats, double earningRate) {
        this.winningStats = winningStats;
        this.earningRate = earningRate;
    }

    public Map<WinningPrize, Integer> getWinningStats() {
        return new HashMap<>(winningStats);
    }

    public double getEarningRate() {
        return earningRate;
    }
}

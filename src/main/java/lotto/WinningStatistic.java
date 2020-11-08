package lotto;

import java.util.Map;

public class WinningStatistic {
    private final Map<WinningRank, Integer> numberOfWinningRanks;
    private final double earningsRate;

    public WinningStatistic(Map<WinningRank, Integer> numberOfWinningRanks, int earningsRate) {
        this.numberOfWinningRanks = numberOfWinningRanks;
        this.earningsRate = earningsRate;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}

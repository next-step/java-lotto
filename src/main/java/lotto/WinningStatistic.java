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

    public Integer getNumberOfWinningRank(WinningRank winningRank) {
        Integer number = numberOfWinningRanks.get(winningRank);
        return number != null ? number : 0;
    }
}

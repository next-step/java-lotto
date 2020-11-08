package lotto;

import java.util.Map;

public class WinningStatistic {
    private final Map<WinningRank, Integer> countOfWinningRanks;
    private final double earningsRate;

    public WinningStatistic(Map<WinningRank, Integer> countOfWinningRanks, int earningsRate) {
        this.countOfWinningRanks = countOfWinningRanks;
        this.earningsRate = earningsRate;
    }

    public double getEarningsRate() {
        return earningsRate;
    }

    public Integer getCountOfWinningRank(WinningRank winningRank) {
        Integer number = countOfWinningRanks.get(winningRank);
        return number != null ? number : 0;
    }
}

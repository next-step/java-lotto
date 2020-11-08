package lotto;

import java.util.Map;

public class WinningStatistic {
    private final Map<WinningRank, Integer> countOfWinningRanks;
    private final String earningsRate;

    public WinningStatistic(Map<WinningRank, Integer> countOfWinningRanks, String earningsRate) {
        this.countOfWinningRanks = countOfWinningRanks;
        this.earningsRate = earningsRate;
    }

    public String getEarningsRate() {
        return earningsRate;
    }

    public Integer getCountOfWinningRank(WinningRank winningRank) {
        Integer number = countOfWinningRanks.get(winningRank);
        return number != null ? number : 0;
    }
}

package lotto.controller.dto;

public class WinStatistic {

    private final int rankCount;
    private final long winAmount;
    private final int matchCount;

    public WinStatistic(int rankCount, long winAmount, int matchCount) {
        this.rankCount = rankCount;
        this.winAmount = winAmount;
        this.matchCount = matchCount;
    }

    public int getRankCount() {
        return rankCount;
    }

    public long getWinAmount() {
        return winAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

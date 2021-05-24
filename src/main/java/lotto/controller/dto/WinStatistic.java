package lotto.controller.dto;

public class WinStatistic {

    private final int rankCount;
    private final long winAmount;
    private final int matchCount;
    private final boolean matchBonusTarget;

    public WinStatistic(int rankCount, long winAmount, int matchCount, boolean matchBonusTarget) {
        this.rankCount = rankCount;
        this.winAmount = winAmount;
        this.matchCount = matchCount;
        this.matchBonusTarget = matchBonusTarget;
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

    public boolean isMatchBonusTarget() {
        return matchBonusTarget;
    }
}

package step2.dto;

public class WinningInfo {
    private final long matchedCondition;
    private final long winningPrize;
    private final long winningCount;

    public WinningInfo(long matchedCondition, long winningPrize, long winningCount) {
        this.matchedCondition = matchedCondition;
        this.winningPrize = winningPrize;
        this.winningCount = winningCount;
    }

    public long calculatePrize() {
        return this.winningPrize * this.winningCount;
    }

    public long getMatchedCondition() {
        return matchedCondition;
    }

    public long getWinningPrize() {
        return winningPrize;
    }

    public long getWinningCount() {
        return winningCount;
    }

}

package step2.dto;

public enum WinningCondition {
    WIN_4TH(3, 5_000),
    WIN_3TH(4, 50_000),
    WIN_2TH(5, 1_500_000),
    WIN_1TH(6, 2_000_000_000),
    ;

    private final long matchedCondition;
    private final long winningPrize;

    WinningCondition(int matchedCondition, long winningPrize) {
        this.matchedCondition = matchedCondition;
        this.winningPrize = winningPrize;
    }

    public long getMatchedCondition() {
        return matchedCondition;
    }

    public long getWinningPrize() {
        return winningPrize;
    }
}

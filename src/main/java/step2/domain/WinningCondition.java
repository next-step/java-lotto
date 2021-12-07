package step2.domain;

public enum WinningCondition {
    WIN_4TH(3, 5000),
    WIN_3TH(4, 50000),
    WIN_2TH(5, 1500000),
    WIN_1TH(6, 2000000000),
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

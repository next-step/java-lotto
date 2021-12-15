package step2.domain;

public enum WinningCondition {
    WIN_NONE(0, 0),
    WIN_5TH(3, 5_000),
    WIN_4TH(4, 50_000),
    WIN_3TH(5, 1_500_000),
    WIN_2TH(5, 30_000_000),
    WIN_1TH(6, 2_000_000_000),
    ;

    private final long matchedCondition;
    private final long winningPrize;

    WinningCondition(int matchedCondition, long winningPrize) {
        this.matchedCondition = matchedCondition;
        this.winningPrize = winningPrize;
    }

    public static WinningCondition calculateWinningRank(long matchedCount, boolean bonusNumber) {
        if (matchedCount == WIN_1TH.matchedCondition) {
            return WIN_1TH;
        }

        if (matchedCount == WIN_2TH.matchedCondition && bonusNumber) {
            return WIN_2TH;
        }

        if (matchedCount == WIN_3TH.matchedCondition) {
            return WIN_3TH;
        }

        if (matchedCount == WIN_4TH.matchedCondition) {
            return WIN_4TH;
        }

        if (matchedCount == WIN_5TH.matchedCondition) {
            return WIN_5TH;
        }

        return WIN_NONE;
    }

    public long getMatchedCondition() {
        return matchedCondition;
    }

    public long getWinningPrize() {
        return winningPrize;
    }
}

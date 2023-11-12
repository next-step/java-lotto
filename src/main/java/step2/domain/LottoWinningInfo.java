package step2.domain;

public enum LottoWinningInfo {
    MATCH_THREE(3,5_000),
    MATCH_FOUR(4,50_000),
    MATCH_FIVE(5,1_500_000),
    MATCH_SIX(6,2_000_000_000);

    private final int matchCount;
    private final int winningMoney;

    LottoWinningInfo(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

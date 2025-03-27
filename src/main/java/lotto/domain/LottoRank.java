package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LAST(0, 0);

    private final int matchNumberCount;
    private final int winningAmount;

    LottoRank(int matchNumberCount, int winningAmount) {
        this.matchNumberCount = matchNumberCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public static LottoRank of(int matchCount){
        for(LottoRank rank : values()) {
            if(rank.matchNumberCount == matchCount) {
                return rank;
            }
        }
        return LAST;
    }
}

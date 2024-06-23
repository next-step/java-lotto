package lotto.model;

public enum LottoRank {
    BAD(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winningPrize;

    LottoRank(int matchCount, int winningPrize) {
        this.matchCount = matchCount;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return FIVE_BONUS;
        }
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return BAD;
    }
}

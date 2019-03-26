package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean bonusNumber) {
        if (countOfMatch < FIFTH.countOfMatch) {
            return MISS;
        }
        LottoRank rank = valueOf(countOfMatch);
        if (SECOND.isMatch(countOfMatch)) {
            return bonusNumber ? SECOND : THIRD;
        }
        return rank;
    }

    private static LottoRank valueOf(int countOfMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.isMatch(countOfMatch))
                return rank;
        }
        throw new IllegalArgumentException();
    }

    private boolean isMatch(int countOfMatch) {
        return this.countOfMatch==countOfMatch;
    }
}

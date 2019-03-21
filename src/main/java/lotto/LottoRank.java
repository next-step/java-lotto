package lotto;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
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

    public static LottoRank valueOf(int countOfMatch) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.isMatch(countOfMatch))
                return rank;
        }
        return MISS;
    }

    private boolean isMatch(int countOfMatch) {
        return this.countOfMatch==countOfMatch;
    }
}

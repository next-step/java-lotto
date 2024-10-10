package lotto.domain;

public enum LottoRank {
    FIRST(1, 2000000000),
    SECOND(2, 30000000),
    THIRD(3, 1500000),
    FOURTH(4, 50000),
    FIFTH(5, 5000),
    NONE(0, 0);

    private final int matchRank;
    private final int prizeMoney;

    LottoRank(int matchRank, int prizeMoney) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchRank() {
        return matchRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static LottoRank valueOf(int matchRank) {
        for (LottoRank rank : values()) {
            if (rank.getMatchRank() == matchRank) {
                return rank;
            }
        }
        return NONE;
    }
}

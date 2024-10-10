package lotto.domain;

public enum LottoRank {
    FIRST(1, 2000000000, 6),
    SECOND(2, 30000000, 6),
    THIRD(3, 1500000, 5),
    FOURTH(4, 50000, 4),
    FIFTH(5, 5000, 3),
    NONE(0, 0, 0);

    private final int matchRank;
    private final int prizeMoney;
    private final int matchCount;

    LottoRank(int matchRank, int prizeMoney, int matchCount) {
        this.matchRank = matchRank;
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getMatchRank() {
        return matchRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
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

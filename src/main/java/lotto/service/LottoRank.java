package lotto.service;

public enum LottoRank {
    FIRST(6, 1),
    SECOND(5, 2),
    THIRD(5, 3),
    FOURTH(4, 4),
    FIFTH(3, 5),
    MISS1(2, 0),
    MISS2(1, 0),
    MISS3(0, 0);

    private int matchCount;
    private int rank;

    LottoRank(int matchCount, int rank) {
        this.matchCount = matchCount;
        this.rank = rank;
    }

    public static int getRankByMatchCount(int matchCount, boolean matchBonus) {
        LottoRank[] rank = values();

        if (matchCount == 6 && !matchBonus) {
            return rank[0].rank;
        }

        if (matchCount == 6) {
            return rank[1].rank;
        }

        if (matchBonus) {
            matchCount--;
            matchCount = Math.max(0, matchCount);
        }

        return rank[7 - matchCount].rank;
    }
}

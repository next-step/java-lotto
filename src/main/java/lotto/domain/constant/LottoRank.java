package lotto.domain.constant;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_00),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final int prizeMoney;

    LottoRank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank fromMatchCount(int matchCount) {
        for (LottoRank rank : LottoRank.values()) {
            if(rank == SECOND){
                continue;
            }
            if (rank.matchCount <= matchCount) {
                return rank;
            }
        }
        return null;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}

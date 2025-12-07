package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 50_000),
    NONE(0, 0);


    private final int matchCount;
    private final int prize;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount) {
        for (LottoRank rank : LottoRank.values()) {
            if (isMatch(rank, matchCount)) {
                return rank;
            }
        }

        return NONE;
    }

    public static boolean isMatch(LottoRank rank, int matchCount) {
        return rank.matchCount == matchCount;
    }

    public int getPrize(LottoRank rank, int count) {
        return rank.prize * count;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, prize);
    }
}

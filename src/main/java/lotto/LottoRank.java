package lotto;

public enum LottoRank {
    FIRST(1,6,false),
    SECOND(2, 5,true),
    THIRD(3, 5,false),
    FOURTH(4, 4,false),
    FIFTH(5, 3,false);

    private int rank;
    private int lottoMatchingCount;
    private boolean isBonusMatched;

    LottoRank(int rank, int lottoMatchingCount, boolean isBonusMatched) {
        this.rank = rank;
        this.lottoMatchingCount = lottoMatchingCount;
        this.isBonusMatched = isBonusMatched;
    }

    public static int convertMatchingCountToRank(int matchingCount, boolean isBonusMatched) {
        for (LottoRank i : values()) {
            if (i.lottoMatchingCount == matchingCount && i.isBonusMatched == isBonusMatched) {
                return i.rank;
            }
        }
        return 0;
    }
    public static int convertRankTomatchingCount(int rank) {
        for (LottoRank i : values()) {
            if (i.rank == rank) {
                return i.lottoMatchingCount;
            }
        }
        return 0;
    }


}

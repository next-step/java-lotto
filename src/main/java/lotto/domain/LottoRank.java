package lotto.domain;

public enum LottoRank {
    BLANK(0, 0)
    , FOURTH(3, 5_000)
    , THIRD(4, 50_000)
    , SECOND(5, 1_500_000)
    , FIRST(6, 2_000_000_000)
    ;

    private int matchCount;
    private int prizeMoney;

    LottoRank(final int matchCount, final int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank findRank(int matchCount) {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.matchCount == matchCount) {
                return lottoRank;
            }
        }
        return LottoRank.BLANK;
    }
}

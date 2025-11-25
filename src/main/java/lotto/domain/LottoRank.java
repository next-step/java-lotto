package lotto.domain;

public enum LottoRank {
    THIRD(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int matchCnt;
    private final int prizeMoney;

    LottoRank(int matchCnt, int prizeMoney) {
        this.matchCnt = matchCnt;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getLottoRank(int matchCnt) {
        for(LottoRank lottoRank : LottoRank.values()) {
            if(lottoRank.matchCnt == matchCnt) {
                return lottoRank;
            }
        }
        return null;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}

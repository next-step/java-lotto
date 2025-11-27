package lotto.domain;

public enum LottoRank {
    MISS(0,0),
    THIRD(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
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
        return LottoRank.MISS;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isAddAble() {
        return this != LottoRank.MISS;
    }
}

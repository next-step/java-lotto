package lotto.domain;

public enum LottoRank {
    THIRD(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final Integer matchCnt;
    private final Integer prizeMoney;

    LottoRank(Integer matchCnt, Integer prizeMoney) {
        this.matchCnt = matchCnt;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank getLottoRank(Integer matchCnt) {
        for(LottoRank lottoRank : LottoRank.values()) {
            if(lottoRank.matchCnt == matchCnt) {
                return lottoRank;
            }
        }
        return null;
    }

    public Integer getMatchCnt() {
        return matchCnt;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}

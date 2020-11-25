package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FIFTH(2, 0),
    LOSEONE(1, 0),
    LOSEZERO(0, 0);

    private int matchCnt;
    private int winnnerPrice;

    Rank(int matchCnt) {
        this.matchCnt = matchCnt;
    }

    Rank(int matchCnt, int winnnerPrice) {
        this.matchCnt = matchCnt;
        this.winnnerPrice = winnnerPrice;
    }

    public int getMatchCnt() {
        return matchCnt;
    }

    public int getWinnnerPrice() {
        return winnnerPrice;
    }

    public static Rank getRankByMatchCnt(int matchCnt){
        for(Rank r : Rank.values()){
            if(r.matchCnt == matchCnt){
                return r;
            }
        }
        return LOSEZERO;
    }
}

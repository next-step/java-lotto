package lotto.domain.enums;

/**
 * 등수별 당첨 숫자 갯수
 */
public enum LottoRank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    NONE;


    private int matchCount;

    LottoRank(int matchCount) {
        this.matchCount = matchCount;
    }

    LottoRank() {

    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoRank getLottoRank(int matchCount){
        if(matchCount == FIRST.getMatchCount()){
            return FIRST;
        }
        if(matchCount == SECOND.getMatchCount()){
            return SECOND;
        }
        if(matchCount == THIRD.getMatchCount()){
            return THIRD;
        }
        if(matchCount == FOURTH.getMatchCount()){
            return FOURTH;
        }
        return NONE;
    }
}

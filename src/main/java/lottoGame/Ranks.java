package lottoGame;

import java.util.Collections;
import java.util.List;

public enum Ranks {
    FOURTH(3, 5000),

    THIRD(4, 50_000),

    SECOND(5, 1_500_000),

    FIRST(6, 2_000_000_000);

    private Integer matchNum;
    private Integer rank;

    Ranks(Integer mathNum, Integer rank) {
        this.matchNum = mathNum;
        this.rank = rank;
    }
    public int findMatch(List<Integer> matchNumbers){
        return Collections.frequency(matchNumbers,matchNum);
    }

    public Integer getMatchNum() {
        return matchNum;
    }

    public Integer getRank() {
        return rank;
    }

}

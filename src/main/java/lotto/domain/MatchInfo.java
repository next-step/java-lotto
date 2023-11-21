package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum MatchInfo {
    MATCH_SIX(6, 2000000000)
    , MATCH_FIVE(5, 1500000)
    , MATCH_FOUR(4, 50000)
    , MATCH_THREE(3, 5000)
    , OTHERS(0, 0);

    private final long count;
    private final int reward;

    MatchInfo(int count, int reward){
        this.count = count;
        this.reward = reward;
    }

    public long getCount(){
        return this.count;
    }

    public int getReward(){
        return this.reward;
    }

    public static MatchInfo checkMatch(long count){
        return Arrays.stream(MatchInfo.values())
                .filter(matchInfo -> matchInfo.count == count)
                .findFirst()
                .orElse(OTHERS);
    }
}

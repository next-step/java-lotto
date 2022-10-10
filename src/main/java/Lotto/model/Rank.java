package Lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ;

    private static final String RANK_ERROR_MESSAGE = "해당하는 순위가 존재하지 않습니다.";
    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
    public static Rank getRank(int matchCount){
        return Arrays.stream(values())
                .filter(it -> it.matchCount == matchCount)
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException(RANK_ERROR_MESSAGE));
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getReward(){
        return reward;
    }
}

package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NON_RANKED(0, 0),
    FOURTH(3, 5000),
    THIRD(4,50000),
    SECOND(5,1500000),
    FIRST(6,2000000000);


    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank rankOf(int matchingCount){
        return Arrays.stream(values())
                .filter(e -> e.matchingCount == matchingCount)
                .findFirst()
                .orElse(NON_RANKED);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }
}

package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2000000000),
    SECOND(5,1500000),
    THIRD(4,50000),
    FOURTH(3, 5000),
    NON_RANKED(0, 0);


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
}

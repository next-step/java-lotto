package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NON_RANKED(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000);


    private final int matchingCount;
    private final int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank rankOf(int matchingCount, boolean containsBonus){
        if (matchingCount == 5 && containsBonus == true) {
            return SECOND;
        }

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

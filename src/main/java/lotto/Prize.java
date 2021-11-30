package lotto;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private static final int DETERMINE_REQUIRED_MATCH_COUNT = 5;

    private final int matchCount;
    private final double prize;

    /*
        CONSTRUCTOR
     */
    Prize(int matchCount, double prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    /*
        INTERFACE
     */
    public static Prize of(int matchCount, boolean bonusContained) {
        if (matchCount == DETERMINE_REQUIRED_MATCH_COUNT) {
            return secondOrThirdPrize(bonusContained);
        }

        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public double getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    /*
                FUNCTION
             */
    private static Prize secondOrThirdPrize(boolean bonusContained) {
        if (bonusContained) {
            return SECOND;
        }
        return THIRD;
    }

}

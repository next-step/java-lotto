package lotto.domain;

import java.util.Arrays;

public enum PrizeType {
    FIRST_PRIZE(6, 2_000_000_000),

    SECOND_PRIZE(5, 1_500_000),

    THIRD_PRIZE(4, 50_000),

    FOURTH_PRIZE(3, 5_000),

    NOT_MATCHING(0, 0);

    private final int numberOfMatching;
    private final long prize;

    PrizeType(int numberOfMatching, long prize) {
        this.numberOfMatching = numberOfMatching;
        this.prize = prize;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public static PrizeType create(int numberOfMatching) {
        return Arrays.stream(PrizeType.values())
                .filter(prizeType -> prizeType.numberOfMatching == numberOfMatching)
                .findFirst()
                .orElse(NOT_MATCHING);
    }

    public long prize() {
        return prize;
    }
}
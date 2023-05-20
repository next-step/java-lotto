package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum PrizeType {
    FIRST_PRIZE(6, 2_000_000_000),

    SECOND_PRIZE(5, 300_000_000),

    THIRD_PRIZE(5, 1_500_000),

    FOURTH_PRIZE(4, 50_000),

    FIFTH_PRIZE(3, 5_000),

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

    public static PrizeType create(int numberOfMatching, boolean bonusMatching) {
        if (checkSecondPrize(numberOfMatching, bonusMatching))
            return PrizeType.SECOND_PRIZE;
        return Stream.of(PrizeType.values())
                .filter(prizeType -> checkNumberOfMatching(numberOfMatching, prizeType))
                .findFirst()
                .orElse(NOT_MATCHING);
    }

    private static boolean checkNumberOfMatching(int numberOfMatching, PrizeType prizeType) {
        return prizeType.numberOfMatching == numberOfMatching;
    }

    private static boolean checkSecondPrize(int numberOfMatching, boolean bonusMatching) {
        return bonusMatching && numberOfMatching == SECOND_PRIZE.numberOfMatching;
    }

    public long prize() {
        return prize;
    }
}
package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum PrizeType {
    FIRST_PRIZE(6, false, 2_000_000_000),

    SECOND_PRIZE(5, true, 30_000_000),

    THIRD_PRIZE(5, false, 1_500_000),

    FOURTH_PRIZE(4, false, 50_000),

    FIFTH_PRIZE(3, false, 5_000),

    NOT_MATCHING(0, false, 0);

    private final int numberOfMatching;
    private final boolean bonusMatching;
    private final long prize;

    PrizeType(int numberOfMatching, boolean bonusMatching, long prize) {
        this.numberOfMatching = numberOfMatching;
        this.bonusMatching = bonusMatching;
        this.prize = prize;
    }

    public int getNumberOfMatching() {
        return numberOfMatching;
    }

    public static PrizeType create(int numberOfMatching, boolean bonusMatching) {
        return Stream.of(PrizeType.values())
                .filter(prizeType -> checkSecondPrize(numberOfMatching, bonusMatching) || checkNumberOfMatching(numberOfMatching, prizeType))
                .findFirst()
                .orElse(NOT_MATCHING);
    }

    private static boolean checkNumberOfMatching(int numberOfMatching, PrizeType prizeType) {
        return prizeType.numberOfMatching == numberOfMatching;
    }

    private static boolean checkSecondPrize(int numberOfMatching, boolean bonusMatching) {
        return bonusMatching && numberOfMatching == 2;
    }

    public long prize() {
        return prize;
    }
}
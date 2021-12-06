package domain;

import java.util.Arrays;
import java.util.Optional;

public enum PrizeCondition {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchingNumber;
    private final int reward;

    PrizeCondition(int matchingNumber, int reward) {
        this.matchingNumber = matchingNumber;
        this.reward = reward;
    }

    public int getMatchingNumber() {
        return matchingNumber;
    }

    public int getReward() {
        return reward;
    }

    public static Optional<PrizeCondition> of(int matchingNumber) {
        return Arrays.stream(values())
                .filter(it -> it.matchingNumber == matchingNumber)
                .findFirst();
    }
}

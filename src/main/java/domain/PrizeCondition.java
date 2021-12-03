package domain;

import java.util.Arrays;
import java.util.Optional;

import static domain.Prize.*;

public enum PrizeCondition {
    FIRST(FIRST_PRIZE_MATCHING_NUMBER, FIRST_PRIZE_REWARD),
    THIRD(THIRD_PRIZE_MATCHING_NUMBER, THIRD_PRIZE_REWARD),
    FOURTH(FOURTH_PRIZE_MATCHING_NUMBER, FOURTH_PRIZE_REWARD),
    FIFTH(FIFTH_PRIZE_MATCHING_NUMBER, FIFTH_PRIZE_REWARD);

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

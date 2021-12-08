package domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum PrizeCondition {
    FIRST(2_000_000_000, 6, (matchCount, matchBonusBall) -> matchCount == 6),
    SECOND(30_000_000, 5, (matchCount, matchBonusBall) -> matchCount == 5 && matchBonusBall),
    THIRD(1_500_000, 5, (matchCount, matchBonusBall) -> matchCount == 5 && !matchBonusBall),
    FOURTH(50_000, 4, (matchCount, matchBonusBall) -> matchCount == 4),
    FIFTH(5_000, 3, (matchCount, matchBonusBall) -> matchCount == 3);

    private final int reward;
    private final int matchCount;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    PrizeCondition(int reward, int matchCount, BiFunction<Integer, Boolean, Boolean> condition) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.condition = condition;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Optional<PrizeCondition> of(int matchingNumber, boolean bonusIncluded) {
        return Arrays.stream(values())
                .filter(it -> it.condition.apply(matchingNumber, bonusIncluded))
                .findFirst();
    }
}

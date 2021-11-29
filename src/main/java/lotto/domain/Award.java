package lotto.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Award {


    NON_MATCH(0, 0, (matchOfCount, isMatchBonus) -> Arrays.asList(0, 1, 2).contains(matchOfCount)),
    MATCH_OF_THREE(3, 5000, (matchOfCount, isMatchBonus) -> matchOfCount == 3),
    MATCH_OF_FOUR(4, 50_000, (matchOfCount, isMatchBonus) -> matchOfCount == 4),
    MATCH_OF_FIVE(5, 1_500_000, (matchOfCount, isMatchBonus) -> matchOfCount == 5 && !isMatchBonus),
    MATCH_OF_FIVE_WITH_BONUS(5, 30_000_000, (matchOfCount, isMatchBonus) -> matchOfCount == 5 && isMatchBonus),
    MATCH_OF_SIX(6, 2_000_000_000, (matchOfCount, isMatchBonus) -> matchOfCount == 6);


    private final int matchCount;
    private final int reward;
    private final BiFunction<Integer, Boolean, Boolean> condition;

    Award(int matchCount, int reward,
        BiFunction<Integer, Boolean, Boolean> condition) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.condition = condition;
    }


    public static Award of(int matchOfCount, boolean isMatchBonus) {
        return Arrays.stream(values())
            .filter(awardV2 -> awardV2.condition.apply(matchOfCount, isMatchBonus))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 갯수입니다."));
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

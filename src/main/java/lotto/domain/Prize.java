package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public enum Prize {

    NONE(0, 0),
    MATCHING_THREE(3, 5_000),
    MATCHING_FOUR(4, 50_000),
    MATCHING_FIVE(5, 1_500_000),
    MATCHING_SIX(6, 2_000_000_000),
    ;

    private static final Map<Integer, Prize> MATCHING_COUNT_TO_PRIZE = Map.of(
        6, MATCHING_SIX,
        5, MATCHING_FIVE,
        4, MATCHING_FOUR,
        3, MATCHING_THREE,
        2, NONE,
        1, NONE,
        0, NONE
    );

    private final int matchingCount;
    private final int amount;

    Prize(int matchingCount, int amount) {
        this.matchingCount = matchingCount;
        this.amount = amount;
    }

    public static Prize from(int matchingCount) {
        Prize prize = MATCHING_COUNT_TO_PRIZE.get(matchingCount);
        Objects.requireNonNull(prize);
        return prize;
    }

    public static Prize[] valuesWithoutNone() {
        return Arrays.stream(values()).filter(prize -> prize != Prize.NONE).toArray(Prize[]::new);
    }

    public int amount() {
        return amount;
    }

    public int matchingCount() {
        return matchingCount;
    }
}

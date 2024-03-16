package lotto.domain;

import java.util.Map;
import java.util.Objects;

public enum Prize {

    NONE(0),
    MATCHING_THREE(5_000),
    MATCHING_FOUR(50_000),
    MATCHING_FIVE(1_500_000),
    MATCHING_SIX(2_000_000_000),
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

    private final int amount;

    Prize(int amount) {
        this.amount = amount;
    }

    public static Prize from(int matchingCount) {
        Prize prize = MATCHING_COUNT_TO_PRIZE.get(matchingCount);
        Objects.requireNonNull(prize);
        return prize;
    }

    public int amount() {
        return amount;
    }
}

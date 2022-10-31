package lotto.domain;

import java.util.Arrays;

public enum Prize {
    SIX(2000000000, 6),
    FIVE_BONUS(30000000, -1),
    FIVE(1500000, 5),
    FOUR(50000, 4),
    THREE(5000, 3),
    NONE(0, -1);

    private final int value;
    private final int matchCount;


    Prize(int value, int matchCount) {
        this.value = value;
        this.matchCount = matchCount;
    }

    public static Prize toPrize(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getValue() {
        return value;
    }
}

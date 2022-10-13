package lotto;

import java.util.Arrays;

public enum Division {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3);

    private final int matchedCount;

    Division(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public static Division valueOf(final int matchedCount){
        return Arrays.stream(Division.values())
            .filter(division -> division.matchedCount == matchedCount)
            .findFirst()
            .orElseThrow();
    }
}

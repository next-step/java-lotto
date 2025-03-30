package lotto.domain;

import java.util.*;

public enum MatchCount {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);
    private final int count;

    MatchCount(int count) {
        this.count = count;
    }

    public static final String INVALID_COUNT_EXCEPTION_MESSAGE = "Customize Toolbar…";

    public int getCount() {
        return this.count;
    }

    public static MatchCount of(int count) {
        return Arrays.stream(values())
                .filter(mc -> mc.count == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT_EXCEPTION_MESSAGE + " : " + count));
    }
}

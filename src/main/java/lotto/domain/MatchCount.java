package lotto.domain;

import java.util.Arrays;

public enum MatchCount {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private static final String INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 값입니다. count: %s";

    private final int count;

    MatchCount(int count) {
        this.count = count;
    }

    public static MatchCount of(int count) {
        return Arrays.stream(values())
                .filter(matchCount -> matchCount.isCountOf(count))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format(INVALID_COUNT_VALUE_EXCEPTION_MESSAGE_FORMAT, count)));
    }

    private boolean isCountOf(int count) {
        return this.count == count;
    }

    public int getCount() {
        return count;
    }
}

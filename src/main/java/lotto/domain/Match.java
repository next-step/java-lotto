package lotto.domain;

import java.util.Arrays;

public enum Match {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final long prize;

    Match(int count, long prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Match of(int count) {
        return Arrays.stream(values())
                .filter(match -> match.count == count)
                .findFirst()
                .orElse(NONE);
    }

    public long getPrize() {
        return prize;
    }
}

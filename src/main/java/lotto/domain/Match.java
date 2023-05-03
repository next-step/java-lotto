package lotto.domain;

import java.util.Arrays;

public enum Match {
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int count;

    Match(int count) {
        this.count = count;
    }

    public static Match of(int count) {
        return Arrays.stream(values())
                .filter(match -> match.count == count)
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return count;
    }
}

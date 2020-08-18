package cc.oakk.lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    FIFTH(2),
    SIXTH(1),
    SEVENTH(0);

    private final int count;
    Rank(int count) {
        this.count = count;
    }

    public static Rank getRankByMatchingCount(int count) {
        return Arrays.stream(Rank.class.getEnumConstants())
                .filter(v -> v.count == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Count should be between 0 and 6"));
    }
}

package cc.oakk.lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(0),
    SECOND(1),
    THIRD(2),
    FOURTH(3),
    FIFTH(4),
    NONE(5);

    private final int differentCount;
    Rank(int differentCount) {
        this.differentCount = differentCount;
    }

    public static Rank getRankByDifferentCount(int count) {
        return Arrays.stream(Rank.class.getEnumConstants())
                .filter(v -> v.differentCount == count)
                .findFirst()
                .orElse(NONE);
    }
}

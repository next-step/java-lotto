package lotto.model.enums;

import java.util.Arrays;

public enum Ranking {
    NONE(0),
    FOURTH(3),
    THIRD(4),
    SECOND(5),
    FIRST(6),
    ;

    private final int matchedCount;

    Ranking(int matchedCount) {
        this.matchedCount = matchedCount;
    }

    public static Ranking result(int matchedCount) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.matchedCount == matchedCount)
                .findFirst()
                .orElse(Ranking.NONE);
    }
}

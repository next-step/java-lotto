package lotto.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {
    NONE((val) -> val < 3),
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    SIX_MATCH(6);

    private final Predicate<Integer> matcher;

    LottoRank(Predicate<Integer> matcher) {
        this.matcher = matcher;
    }

    LottoRank(int matchCount) {
        this((val) -> val == matchCount);
    }

    public static LottoRank match(final int value) {
        return Arrays.stream(values()).filter(v -> v.matcher.test(value)).findFirst().orElse(NONE);
    }
}

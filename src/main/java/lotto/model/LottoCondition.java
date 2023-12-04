package lotto.model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoCondition {
    FIRST(6, (matchedCount, matchBonus) -> matchedCount == 6),
    SECOND(5, (matchedCount, matchBonus) -> matchedCount == 5 && matchBonus),
    THIRD(5, (matchedCount, matchBonus) -> matchedCount == 5 && !matchBonus),
    FOURTH(4, (matchedCount, matchBonus) -> matchedCount == 4),
    FIFTH(3, (matchedCount, matchBonus) -> matchedCount == 3),
    LAST(0, (matchedCount, matchBonus) -> matchedCount < 3);

    private static final String ERR_INVALID_MATCH_COUNT = "The number of matched lotto numbers cannot exceed 6, as there are a total of 6 lotto numbers.";
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    LottoCondition(int matchCount, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.condition = condition;
    }

    public static LottoCondition valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.test(matchCount, matchBonus))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_MATCH_COUNT));
    }

    public int matchCount() {
        return this.matchCount;
    }
}

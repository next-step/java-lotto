package step2_pobi.domain;

import java.util.Arrays;
import java.util.EnumMap;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(5, 50000),
    FOURTH(4, 5000),
    FIFTH(3, 0),
    NO_MATCH(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank rank(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.matchCount) {
            return NO_MATCH;
        }
        if (SECOND.isMatchCount(matchCount)) {
            if (matchBonus) {
                return SECOND;
            }
            return THIRD;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}

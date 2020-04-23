package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_500_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0),
    ;

    public static final String ILLEGAL_MATCH_COUNT = "match count must be greater than zero";

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static List<Rank> winningValues() {
        return Arrays.stream(values())
                .filter(value -> value != FAIL)
                .collect(Collectors.toList());
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        Rank rank = valueOf(matchCount);
        if (rank.matchCount == SECOND.matchCount) {
            return matchBonus ? SECOND : THIRD;
        }
        return rank;
    }

    public static Rank valueOf(int matchCount) {
        validateMatchCount(matchCount);
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount) {
                return rank;
            }
        }
        return FAIL;
    }

    private static void validateMatchCount(int matchCount) {
        if (matchCount < 0) {
            throw new IllegalArgumentException(ILLEGAL_MATCH_COUNT);
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}

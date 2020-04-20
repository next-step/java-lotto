package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Match {

    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    FAIL(0, 0),
    ;

    public static final String ILLEGAL_MATCH_COUNT = "match count must be greater than zero";

    private final int matchCount;
    private final int prizeMoney;

    Match(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static List<Match> winningValues() {
        return Arrays.stream(values())
                .filter(value -> value != FAIL)
                .collect(Collectors.toList());
    }

    public static Match valueOf(int matchCount) {
        validateMatchCount(matchCount);
        for (Match match : values()) {
            if (match.matchCount == matchCount) {
                return match;
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

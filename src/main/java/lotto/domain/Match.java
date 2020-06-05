package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Match {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NONE(0,0)
    ;

    private final int matchCount;
    private final int prizeMoney;

    Match(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Match findByMatchCount(int matchCount){
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static int priceMoneySum(List<Match> matches){
        return matches.stream()
                .mapToInt(map -> map.prizeMoney)
                .sum();
    }
}

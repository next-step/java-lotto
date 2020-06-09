package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0,0)
    ;

    private final int matchCount;
    private final int prizeMoney;

    Rank(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank findByMatchCount(int matchCount){
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public static int priceMoneySum(Map<Rank, Long> matches){
        return matches.entrySet().stream()
                .mapToInt(entry -> (int) (entry.getKey().getPrizeMoney() * entry.getValue()))
                .sum();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}

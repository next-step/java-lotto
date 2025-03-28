package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum Division {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    public final static Map<Division, Integer> matchCounts = new EnumMap<>(Division.class);

    static {
        matchCounts.put(Division.FIFTH, 0);
        matchCounts.put(Division.FOURTH, 0);
        matchCounts.put(Division.THIRD, 0);
        matchCounts.put(Division.FIRST, 0);
    }

    private int matchCount;
    private int prize;

    private Division(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static Division getDivision(int matchCount) {
        return Arrays.stream(values())
                .filter(division -> division.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public final static Map<Division, Integer> getMatchCounts() {
        return matchCounts;
    }
}

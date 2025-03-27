package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum Division {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int prize;

    private static Map<Division, Integer> matchCountMap = new EnumMap<>(Division.class);

    static {
        for (Division division : Division.values()) {
            matchCountMap.put(division, 0);
        }
    }

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
                .map(division -> {
                    matchCountMap.put(division, matchCountMap.get(division) + 1);
                    return division;
                })
                .orElse(null);
    }

    public static Map<Division, Integer> getMatchCountMap() {
        return matchCountMap;
    }
}

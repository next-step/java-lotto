package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private static final int DEFAULT_MATCH_COUNT = 0;
    private final int matchCount;
    private final int cash;

    Rank(int matchCount, int cash) {
        this.matchCount = matchCount;
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public static Map<Rank, Integer> makeEmptyRankMap() {
        Map<Rank, Integer> rankMap = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(winner -> rankMap.put(winner, DEFAULT_MATCH_COUNT));
        return rankMap;
    }

    public static Rank find(int matchCount, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(targetRank -> targetRank.matchCount == matchCount)
                .findFirst().orElse(NONE);

        if (rank == Rank.THIRD && matchBonus) {
            return Rank.SECOND;
        }
        return rank;
    }

}
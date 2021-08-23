package lotto.domain;

import java.util.*;

public enum Rank {

    FIRST(6, 2000000000, "6개 일치"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1500000,"5개 일치"),
    FOURTH(4, 50000, "4개 일치"),
    FIFTH(3,5000, "3개 일치"),
    NONE(0, 0, "0개 일치");

    private static final int DEFAULT_MATCH_COUNT = 0;
    private final int matchCount;
    private final int cash;
    private final String description;

    Rank(int matchCount, int cash, String description) {
        this.matchCount = matchCount;
        this.cash = cash;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getCash() {
        return cash;
    }

    public String getDescription() {
        return description;
    }

    public static Rank find(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(winner -> winner.matchCount == matchCount)
                .findFirst().orElse(NONE);
    }

    public static Map<Rank, Integer> makeWinnerRank() {
        Map<Rank, Integer> rankMap = new HashMap<>();
        Arrays.stream(Rank.values())
                .forEach(winner -> rankMap.put(winner, DEFAULT_MATCH_COUNT));
        return rankMap;
    }

    public static Rank find(int matchCount, boolean matchBonus) {
        Rank rank = Arrays.stream(Rank.values())
                .filter(targetRank -> targetRank.matchCount == matchCount)
                .findFirst().orElse(NONE);

        if(rank == Rank.THIRD && matchBonus) {
            return Rank.SECOND;
        }
        return rank;
    }

}
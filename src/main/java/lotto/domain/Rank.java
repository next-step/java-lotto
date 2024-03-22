package lotto.domain;

import java.util.*;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50000),
    FIFTH(3, 1500000),
    MISS(0, 0)
    ;

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    private static final Map<Integer, Rank> rankMap = new HashMap<>();
    static {
        for (Rank rank : Rank.values()) {
            rankMap.put(rank.matchCount, rank);
        }
    }

    public static List<Rank> getRanks() {
        return List.of(Rank.values());
    }

    public static Rank lookup(int matchCount) {
        Rank rank = rankMap.get(matchCount);
        if (hasRank(rank)) {
            return rank;
        }
        return MISS;
    }

    private static boolean hasRank(Rank rank) {
        return rank != null;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}

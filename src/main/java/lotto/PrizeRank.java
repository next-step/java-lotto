package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum PrizeRank {
    FIRST(MatchCount.of(6), 2_000_000_000),
    SECOND(MatchCount.of(5), 30_000_000),
    THIRD(MatchCount.of(5), 1_500_000),
    FOURTH(MatchCount.of(4), 50_000),
    FIFTH(MatchCount.of(3), 5_000),
    NONE(MatchCount.of(0), 0);

    private final MatchCount matchCount;
    private final int prize;

    PrizeRank(MatchCount matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public MatchCount getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    private static final Map<Integer, PrizeRank> CACHE;

    static {
        Map<Integer, PrizeRank> map = new HashMap<>();
        for (PrizeRank rank : values()) {
            map.put(rank.matchCount.getCount(), rank);
        }
        CACHE = Collections.unmodifiableMap(map);
    }

    public static PrizeRank of(int matchCount, boolean bonus) {
        if (matchCount == 5) {
            return bonus ? SECOND : THIRD;
        }
        return CACHE.getOrDefault(matchCount, NONE);
    }
}

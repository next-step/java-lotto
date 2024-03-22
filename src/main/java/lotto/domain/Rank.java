package lotto.domain;

import java.util.*;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0)
    ;

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (isSecondOrThird(matchCount)) {
            return getSecondOrThird(matchBonus);
        }
        
        Optional<Rank> optionalRank = findRankByMatchCount(matchCount);
        if (optionalRank.isEmpty()) {
            return MISS;
        }
        
        return optionalRank.get();
    }

    private static Optional<Rank> findRankByMatchCount(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter((rank) -> rank.matchCount == matchCount)
                .findFirst();
    }

    private static boolean isSecondOrThird(int matchCount) {
        return matchCount == 5;
    }

    private static Rank getSecondOrThird(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

}

package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0,0),
    FIFTH(3,5_000),
    FOURTH(4,50_000),
    THIRD(5,1_500_000),
    SECOND(5,30_000_000),
    FIRST(6,2_000_000_000)
    ;

    private int matchCount;
    private int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int prize(Rank targetRank) {
        int prize = 0;
        for (Rank rank : values()) {
            prize += prize(targetRank, rank);
        }
        return prize;
    }

    private static int prize(Rank targetRank, Rank rank) {
        if( rank  == targetRank) {
            return rank.prize;
        }
        return 0;
    }

    public static Rank of(int matchCount, boolean bonusMatch) {
        Rank rank = Arrays.asList(
                Rank.NONE,
                Rank.NONE,
                Rank.NONE,
                Rank.FIFTH,
                Rank.FOURTH,
                Rank.THIRD,
                Rank.FIRST
        ).get(matchCount);

        if( bonusMatch && Rank.THIRD == rank ) {
            return Rank.SECOND;
        }

        return rank;
    }

    public int matchCount() {
        return matchCount;
    }
    public int prize() {
        return prize;
    }
}

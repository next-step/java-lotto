package lotto.domain;

import java.util.Arrays;

public enum Rank {
    nothing(0,0),
    threeNumbersMatch(3,5_000),
    fourNumbersMatch(4,50_000),
    fiveNumbersMatch(5,1_500_000),
    sixNumbersMatch(6,2_000_000_000)
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

    public static Rank of(int matchCount) {
        return Arrays.asList(
                Rank.nothing,
                Rank.nothing,
                Rank.nothing,
                Rank.threeNumbersMatch,
                Rank.fourNumbersMatch,
                Rank.fiveNumbersMatch,
                Rank.sixNumbersMatch
        ).get(matchCount);
    }

}

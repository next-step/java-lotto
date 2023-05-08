package lotto.domian;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0)
    ;

    private int matchingCount;
    private int prize;

    Rank(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Rank find(int matchingCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

}

package lotto.domian;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false)
    ;

    private int matchingCount;
    private int prize;
    private boolean isBonusBall;

    Rank(int matchingCount, int prize, boolean isBonusBall) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.isBonusBall = isBonusBall;
    }

    public static Rank find(int matchingCount, boolean isBonusBall) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchingCount == matchingCount
                        && rank.isBonusBall == isBonusBall)
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

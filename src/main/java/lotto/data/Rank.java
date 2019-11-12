package lotto.data;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private int matchCount;
    private int prize;
    private boolean isDependsBonus;

    Rank(int matchCount, int prize, boolean isDependsBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isDependsBonus = isDependsBonus;
    }

    public long getTotalPrize(long count) {
        return count * prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isDependsBonus() {
        return isDependsBonus;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Rank.values())
              .filter(rank -> rank.isDependsBonus ? rank.matchCount == matchCount && isMatchBonus : rank.matchCount == matchCount)
              .findAny().orElse(Rank.MISS);
    }
}


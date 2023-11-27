package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 1_000_000_000),
    SECOND(5, 40_000_000),
    THIRD(5, 2_000_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOT(0, 0);

    private final int matchCount;
    private final long amount;

    Rank(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank matchRank(int num, boolean isMatchBonusNum) {
        if (num == 5) {
            return isMatchBonusNum ? Rank.SECOND : Rank.THIRD;
        }

        return Arrays.stream(Rank.values())
            .filter(r -> r.equalNum(num))
            .findAny()
            .orElse(Rank.NOT);
    }

    private boolean equalNum(int num) {
        return this.matchCount == num;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }
}

package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOUR(3, 5_000),
    NOTHING(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static Rank valueOfRank(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.sameMatchCount(matchCount))
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    private boolean sameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}

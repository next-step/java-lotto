package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOUR(4, 50_000),
    FIVE(3,5_000),
    NOTHING(0, 0);

    private int matchCount;
    private int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public boolean isNothing() {
        return this == Rank.NOTHING;
    }

    private boolean isSecond() {
        return this == Rank.SECOND;
    }

    public static Rank valueOfRank(int matchCount, boolean isBonus) {
        if (isSecond(matchCount, isBonus)) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.sameMatchCount(matchCount) && !rank.isSecond())
                .findFirst()
                .orElse(Rank.NOTHING);
    }

    private static boolean isSecond(int matchCount, boolean isBonus) {
        return SECOND.getMatchCount() == matchCount && isBonus;
    }

    private boolean sameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int getMoney() {
        return money;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

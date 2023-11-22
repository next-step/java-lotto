package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ZERO("0개 일치", 0, 0),
    FIFTH("3개 일치", 3, 5_000),
    FOURTH("4개 일치", 4, 50_000),
    THIRD("5개 일치", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치", 5, 30_000_000),
    FIRST("6개 일치", 6, 2_000_000_000);

    private static final Rank[] VALUES = values();

    private final String title;
    private final int matchCount;
    private final int prizeMoney;

    Rank(String title, int matchCount, int prizeMoney) {
        this.title = title;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank rankByCount(int count, boolean isMatchBonus) {
        if (count == 5) {
            return isMatchBonus ? Rank.SECOND : Rank.THIRD;
        }

        return Arrays.stream(VALUES)
                .filter(rank -> rank.matchCount == count)
                .findFirst()
                .orElse(Rank.ZERO);
    }

    public String getTitle() {
        return title;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}

package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);

    private static final String NOT_EXIST_VALUE = "존재하지 않는 값입니다.";

    private final int matchCount;
    private final long money;
    private final boolean isMatchBonus;

    Statistics(int matchCount, long money, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.isMatchBonus = isMatchBonus;
    }

    public static Statistics getStatisticsByMatchCount(int matchCount, boolean isMatchBonus) {
        return Arrays.stream(Statistics.values())
                .filter(statistics -> statistics.getMatchCount() == matchCount && statistics.isMatchBonus() == isMatchBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_VALUE));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}

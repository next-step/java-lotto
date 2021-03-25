package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private static final String NOT_EXIST_VALUE = "존재하지 않는 값입니다.";
    private final int matchCount;
    private final long money;

    Statistics(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Statistics getStatisticsByMatchCount(int num) {
        return Arrays.stream(Statistics.values())
                .filter(statistics -> statistics.getMatchCount() == num)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_VALUE));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }
}

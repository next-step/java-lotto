package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private int matchCount;
    private long money;

    Statistics(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Statistics getStatistics(int num) {
        return Arrays.stream(Statistics.values())
                .filter(statistics -> statistics.getMatchCount() == num)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 값입니다."));
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    public static double getYield(int buyAmount, long winningAmount) {
        return winningAmount / (double) buyAmount;
    }
}

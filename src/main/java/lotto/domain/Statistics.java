package lotto.domain;

import java.util.Arrays;

public enum Statistics {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private static final String NOT_EXIST_VALUE = "존재하지 않는 값입니다.";
    private final int matchCount;
    private final long money;

    Statistics(int matchCount, long money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Statistics getStatisticsByMatchCount(int matchCount, boolean isMatchBonus) {
        if(5 == matchCount && isMatchBonus){
            return Statistics.BONUS;
        }

        if(5 == matchCount && !isMatchBonus){
            return Statistics.FIVE;
        }

        return Arrays.stream(Statistics.values())
                .filter(statistics -> statistics.getMatchCount() == matchCount)
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

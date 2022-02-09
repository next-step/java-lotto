package lotto.domain;

import java.util.Arrays;

public enum Statistics {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private static final String STATISTICS_INVALID = "존재 하지 않는 등수 입니다.";
    final int match;
    final int money;

    Statistics(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }

    public static Statistics getReward(int matchCount, boolean bonus) {
        Statistics statistics = Arrays.stream(values())
            .filter(match -> match.match == matchCount)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(STATISTICS_INVALID));

        if (statistics.match == THIRD.match && bonus) {
            return SECOND;
        }

        return statistics;
    }

    public boolean isSecond() {
        return this.equals(SECOND);
    }
}

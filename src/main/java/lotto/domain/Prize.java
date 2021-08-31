package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchingCount;
    private final int money;

    Prize( int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.money = prizeMoney;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int money() {
        return money;
    }

    int calculateWinningMoney(int count) {
        return money * count;
    }

    public static Prize valueOf(int matchingCount, boolean matchingBonus) {
        if (matchingCount < FIFTH.matchingCount) {
            return NONE;
        }

        if (matchingCount == SECOND.matchingCount) {
            return matchingBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(p -> matchingCount == p.matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 값을 가진 Prize는 없습니다." + matchingCount));
    }
}

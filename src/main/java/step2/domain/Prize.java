package step2.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0,0);

    private final int matched;
    private final int prizeMoney;

    Prize(int matched, int prizeMoney) {
        this.matched = matched;
        this.prizeMoney = prizeMoney;
    }

    public int getMatched() {
        return matched;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static int getWinningMoney(int count) {
        return Arrays.stream(Prize.values())
                    .filter(matchedCount -> matchedCount.matched == count)
                    .findFirst()
                    .orElse(NONE)
                    .getPrizeMoney();
    }
}

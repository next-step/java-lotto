package lotto.domain.prize;

import java.util.Arrays;

public enum Prize {

    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5,  1500000),
    FIRST(6,  2000000000);

    private int matchedNumbersCount;
    private int prizeMoney;

    Prize(final int matchedNumbersCount, final int prizeMoney) {
        this.matchedNumbersCount = matchedNumbersCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize of(final int matchedNumbersCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchedNumbersCount == matchedNumbersCount)
                .findFirst()
                .orElse(Prize.MISS);
    }
}

package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST_PLACE("1등", 6, 2000000000),
    SECOND_PLACE("2등", 5, 1500000),
    THIRD_PLACE("3등", 4, 50000),
    FOURTH_PLACE("4등", 3, 5000),
    OUT_OF_PLACE("등수 외", 0, 0);

    private final String desc;
    private final int matchingCount;
    private final int prizeMoney;

    Prize(String desc, int matchingCount, int prizeMoney) {
        this.desc = desc;
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public static Prize valueOf(int matchingCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchingCount == matchingCount)
                .findFirst()
                .orElse(OUT_OF_PLACE);
    }

    public static int calculatePriceMoney(Prize prize, int count) {
        return prize.prizeMoney * count;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}

package lotto.constant;

import java.util.Arrays;

public enum Rank {
    FIFTH(2, 0, "꽝"),
    FOURTH(3, 5_000, "3개 일치 (5,000원) - "),
    THIRD(4, 50_000, "4개 일치 (50,000원) - "),
    SECOND(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchingNumberCount;
    private final int prizeMoney;
    private final String description;

    Rank(int matchingNumberCount, int prizeMoney, String description) {
        this.matchingNumberCount = matchingNumberCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Rank value(int matchingCount) {
        if (matchingCount < 3) {
            return FIFTH;
        }
        return Arrays.stream(values())
                .filter(value -> value.matchingNumberCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("number is wrong rank."));
    }
}

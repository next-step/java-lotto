package lotto.domain;

import java.util.Arrays;

public enum PrizeType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int numberOfMatch;
    private final int prizeMoney;

    PrizeType(int numberOfMatch, int prizeMoney) {
        this.numberOfMatch = numberOfMatch;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeType findPrizeType(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(prizeType -> prizeType.numberOfMatch == numberOfMatch)
                .findFirst().orElse(null);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        return numberOfMatch + "개 일치 (" + prizeMoney + "원)";
    }
}

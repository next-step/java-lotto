package lotto.domain;

import java.util.Arrays;

public enum WinningInformation {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NO_PRIZE(0, false, 0);

    private final int countOfMatchedNumber;
    private final boolean isRequiredBonus;
    private final long prizeMoney;

    WinningInformation(final int countOfMatchedNumber, final boolean isRequiredBonus, final long prizeMoney) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.isRequiredBonus = isRequiredBonus;
        this.prizeMoney = prizeMoney;
    }

    public static WinningInformation findByMatchedInformation(final int count, final boolean isRequiredBonus) {
        return Arrays.stream(values())
            .filter(wi -> (wi.countOfMatchedNumber == count) && (wi.isRequiredBonus == isRequiredBonus))
            .findFirst()
            .orElse(NO_PRIZE);
    }

    public int getCountOfMatchedNumber() {
        return countOfMatchedNumber;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}

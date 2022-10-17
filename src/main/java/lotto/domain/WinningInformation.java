package lotto.domain;

import java.util.Arrays;

public enum WinningInformation {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NO_PRIZE(0, 0);

    private final int countOfMatchedNumber;
    private final long prizeMoney;

    WinningInformation(final int countOfMatchedNumber, final long prizeMoney) {
        this.countOfMatchedNumber = countOfMatchedNumber;
        this.prizeMoney = prizeMoney;
    }

    public static WinningInformation findByCountOfMatchedNumber(final int count) {
        return Arrays.stream(values())
            .filter(wi -> wi.countOfMatchedNumber == count)
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

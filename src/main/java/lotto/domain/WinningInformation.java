package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum WinningInformation {

    NOT_MATCHES(0, 0),
    ONE_MATCHES(1, 0),
    TWO_MATCHES(2, 0),
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matchesCount;
    private final int amount;

    WinningInformation(int matchesCount, int prizeMoney) {
        this.matchesCount = matchesCount;
        this.amount = prizeMoney;
    }

    public static WinningInformation of(int matchesCount) {
        return Arrays.stream(values())
                .filter(w -> w.matchesCount == matchesCount)
                .findFirst()
                .orElse(NOT_MATCHES);
    }

    public static int sumAmounts(List<WinningInformation> winningInformations) {
        return winningInformations.stream()
                .mapToInt(w -> w.amount)
                .sum();
    }
}

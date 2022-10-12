package lotto.domain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public enum WinningInformation {

    NOT_MATCHES(0, BigInteger.valueOf(0)),
    ONE_MATCHES(1, BigInteger.valueOf(0)),
    TWO_MATCHES(2, BigInteger.valueOf(0)),
    THREE_MATCHES(3, BigInteger.valueOf(5_000)),
    FOUR_MATCHES(4, BigInteger.valueOf(50_000)),
    FIVE_MATCHES(5, BigInteger.valueOf(1_500_000)),
    SIX_MATCHES(6, BigInteger.valueOf(2_000_000_000));

    private final int matchesCount;
    private final BigInteger amount;

    WinningInformation(int matchesCount, BigInteger amount) {
        this.matchesCount = matchesCount;
        this.amount = amount;
    }

    public static WinningInformation of(int matchesCount) {
        return Arrays.stream(values())
                .filter(w -> w.matchesCount == matchesCount)
                .findFirst()
                .orElse(NOT_MATCHES);
    }

    public static BigInteger sumAmounts(List<WinningInformation> winningInformations) {
        return winningInformations.stream()
                .map(it -> it.amount)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}

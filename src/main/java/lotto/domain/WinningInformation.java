package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningInformation {

    NOT_MATCHES(0, new Money(0)),
    ONE_MATCHES(1, new Money(0)),
    TWO_MATCHES(2, new Money(0)),
    THREE_MATCHES(3, new Money(5_000)),
    FOUR_MATCHES(4, new Money(50_000)),
    FIVE_MATCHES(5, new Money(1_500_000)),
    SIX_MATCHES(6, new Money(2_000_000_000));

    private final int matchesCount;
    private final Money amount;

    WinningInformation(int matchesCount, Money amount) {
        NullCheckUtil.validate(amount);
        this.matchesCount = matchesCount;
        this.amount = amount;
    }

    public static WinningInformation of(int matchesCount) {
        return Arrays.stream(values())
                .filter(w -> w.matchesCount == matchesCount)
                .findFirst()
                .orElse(NOT_MATCHES);
    }

    public static Money sumAmounts(List<WinningInformation> winningInformations) {
        return Money.sumMoney(
                winningInformations.stream()
                        .map(w -> w.amount)
                        .collect(Collectors.toList())
        );
    }

    public int getMatchesCount() {
        return matchesCount;
    }

    public Money getAmount() {
        return amount;
    }
}

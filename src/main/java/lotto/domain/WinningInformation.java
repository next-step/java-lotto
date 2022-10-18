package lotto.domain;

import lotto.util.NullCheckUtil;

import java.math.BigInteger;
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
    FIVE_AND_BONUS_MATCHES(5, new Money(30_000_000)),
    SIX_MATCHES(6, new Money(2_000_000_000));

    private final int matchesCount;
    private final Money amount;

    WinningInformation(int matchesCount, Money amount) {
        NullCheckUtil.validate(amount);
        this.matchesCount = matchesCount;
        this.amount = amount;
    }

    public static WinningInformation from(int matchesCount) {
        return Arrays.stream(values())
                .filter(w -> w.matchesCount == matchesCount)
                .findFirst()
                .orElse(NOT_MATCHES);
    }

    public static WinningInformation of(int matchesCount, boolean isBonusMatch) {
        if (isFiveAndBonus(matchesCount, isBonusMatch)) {
            return FIVE_AND_BONUS_MATCHES;
        }
        return from(matchesCount);
    }

    private static boolean isFiveAndBonus(int matchesCount, boolean isBonusMatch) {
        return matchesCount == 5 && isBonusMatch;
    }

    public static Money sumAmounts(List<WinningInformation> winningInformations) {
        return Money.sumMoney(
                winningInformations.stream()
                        .map(w -> w.amount)
                        .collect(Collectors.toList())
        );
    }

    public int amountCompareTo(Money money) {
        return amount.compareTo(money);
    }

    public BigInteger findAmountValue() {
        return amount.getValue();
    }

    public int getMatchesCount() {
        return matchesCount;
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "WinningInformation{" +
                "matchesCount=" + matchesCount +
                ", amount=" + amount +
                '}';
    }
}

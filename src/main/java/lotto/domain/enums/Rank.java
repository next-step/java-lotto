package lotto.domain.enums;

import lotto.domain.Money;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000L, 6, false),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5, false),
    FOURTH(50_000L, 4, false),
    FIFTH(5_000L, 3, false),
    MISS(0L, 0, false);

    private final Money winningAmount;
    private final Integer matchedCount;
    private final boolean bonusMatchRequired;

    Rank(Long winningAmount, Integer matchedCount, boolean bonusMatchRequired) {
        this.winningAmount = Money.of(winningAmount);
        this.matchedCount = matchedCount;
        this.bonusMatchRequired = bonusMatchRequired;
    }

    public Money winningAmount() {
        return winningAmount;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public Money winningAmountByCount(Integer count) {
        return winningAmount.multiply(count);
    }

    public static Rank of(int matchedCount, boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedCount == matchedCount)
                .filter(rank -> bonusMatchedIfRequires(bonusMatched, rank))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean bonusMatchedIfRequires(boolean bonusMatched, Rank rank) {
        if (rank.bonusMatchRequired) {
            return bonusMatched;
        }

        return true;
    }
}

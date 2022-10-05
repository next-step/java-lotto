package lotto.domain.enums;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000L, 6, false),
    SECOND(30_000_000L, 5, true),
    THIRD(1_500_000L, 5, false),
    FOURTH(50_000L, 4, false),
    FIFTH(5_000L, 3, false),
    MISS(0L, 0, false);

    private final BigDecimal winningAmount;
    private final Integer matchedCount;
    private final boolean bonusMatchRequired;

    Rank(Long winningAmount, Integer matchedCount, boolean bonusMatchRequired) {
        this.winningAmount = BigDecimal.valueOf(winningAmount);
        this.matchedCount = matchedCount;
        this.bonusMatchRequired = bonusMatchRequired;
    }

    public BigDecimal winningAmount() {
        return winningAmount;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public BigDecimal winningAmountByCount(Integer count) {
        return winningAmount.multiply(BigDecimal.valueOf(count));
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

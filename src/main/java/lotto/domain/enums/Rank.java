package lotto.domain.enums;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000L, 6),
    SECOND(30_000_000L, 5),
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3),
    MISS(0L, 0);

    private final BigDecimal winningAmount;
    private final Integer matchedCount;

    Rank(Long winningAmount, Integer matchedCount) {
        this.winningAmount = BigDecimal.valueOf(winningAmount);
        this.matchedCount = matchedCount;
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
        if (bonusMatched && matchedCount == SECOND.matchedCount) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank != SECOND && rank.matchedCount == matchedCount)
                .findFirst()
                .orElse(MISS);
    }
}

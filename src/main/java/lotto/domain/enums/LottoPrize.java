package lotto.domain.enums;

import java.math.BigDecimal;

public enum LottoPrize {
    FIRST(2_000_000_000L, 6),
// TODO SECOND,
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3);

    private final BigDecimal amount;
    private final Integer matchedCount;

    LottoPrize(Long amount, Integer matchedCount) {
        this.amount = BigDecimal.valueOf(amount);
        this.matchedCount = matchedCount;
    }

    public BigDecimal amount() {
        return amount;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public BigDecimal amountByCount(Integer count) {
        return amount.multiply(BigDecimal.valueOf(count));
    }
}

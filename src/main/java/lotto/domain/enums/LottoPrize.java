package lotto.domain.enums;

import java.math.BigDecimal;

public enum LottoPrize {
    FIRST(2_000_000_000L, 6),
// TODO SECOND,
    THIRD(1_500_000L, 5),
    FOURTH(50_000L, 4),
    FIFTH(5_000L, 3);

    private final BigDecimal money;
    private final Integer matchedCount;

    LottoPrize(Long money, Integer matchedCount) {
        this.money = BigDecimal.valueOf(money);
        this.matchedCount = matchedCount;
    }

    public BigDecimal money() {
        return money;
    }

    public Integer matchedCount() {
        return matchedCount;
    }
}

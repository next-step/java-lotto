package lotto.domain.enums;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Rank {
    FIRST(2_000_000_000L, 6, List.of(TRUE, FALSE)),
    SECOND(30_000_000L, 5, List.of(TRUE)),
    THIRD(1_500_000L, 5, List.of(FALSE)),
    FOURTH(50_000L, 4, List.of(TRUE, FALSE)),
    FIFTH(5_000L, 3, List.of(TRUE, FALSE)),
    MISS(0L, 0, List.of(TRUE, FALSE));

    private final BigDecimal winningAmount;
    private final Integer matchedCount;
    private final List<Boolean> bonusMatchedStates;

    Rank(Long winningAmount, Integer matchedCount, List<Boolean> bonusMatchedStates) {
        this.winningAmount = BigDecimal.valueOf(winningAmount);
        this.matchedCount = matchedCount;
        this.bonusMatchedStates = bonusMatchedStates;
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
                .filter(rank -> rank.matchedCount == matchedCount && rank.bonusMatchedStates.contains(bonusMatched))
                .findFirst()
                .orElse(MISS);
    }
}

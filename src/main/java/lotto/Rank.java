package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

public enum Rank {
    FIRST(Set.of(6), BigDecimal.valueOf(2_000_000_000)),
    SECOND(Set.of(5), BigDecimal.valueOf(1_500_000)),
    THIRD(Set.of(4), BigDecimal.valueOf(50_000)),
    FORTH(Set.of(3), BigDecimal.valueOf(5_000)),
    NONE(Set.of(1, 2), BigDecimal.valueOf(0))
    ;

    private final Set<Integer> matchNumberCount;
    private final BigDecimal winPrice;

    Rank(Set<Integer> matchNumberCount, BigDecimal winPrice) {
        this.matchNumberCount = matchNumberCount;
        this.winPrice = winPrice;
    }

    public static Rank getRank(int matchNumberCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumberCount.contains(matchNumberCount))
                .findFirst()
                .orElse(NONE);
    }

    public BigDecimal getWinPrice() {
        return winPrice;
    }
}

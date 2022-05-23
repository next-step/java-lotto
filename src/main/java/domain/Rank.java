package domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, BigDecimal.valueOf(2000000000)),
    SECOND(5, BigDecimal.valueOf(1500000)),
    THIRD(4, BigDecimal.valueOf(50000)),
    FOURTH(3, BigDecimal.valueOf(5000)),
    LOST(0, BigDecimal.ZERO);

    private final int matchCount;
    private final BigDecimal winningMoney;

    Rank(int matchCount, BigDecimal winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isSameMatchCount(matchCount))
                .findAny()
                .orElse(LOST);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getWinningMoney() {
        return winningMoney;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}

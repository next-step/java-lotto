package domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, new Cash(2_000_000_000)),
    SECOND(5, new Cash(1_500_000)),
    THIRD(4, new Cash(50_000)),
    FOURTH(3, new Cash(5_000)),
    LOST(0, new Cash(0));

    private final int matchCount;
    private final Cash winningMoney;

    Rank(int matchCount, Cash winningMoney) {
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

    public Cash getWinningMoney() {
        return winningMoney;
    }

    private boolean isSameMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}

package lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Set;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    NONE(0, 0)
    ;

    private final int matchNumberCount;
    private final long winPrice;

    Rank(int matchNumberCount, long winPrice) {
        this.matchNumberCount = matchNumberCount;
        this.winPrice = winPrice;
    }

    public static Rank getRank(int matchNumberCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchNumberCount == matchNumberCount)
                .findFirst()
                .orElse(NONE);
    }

    public long getWinPrice() {
        return winPrice;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}

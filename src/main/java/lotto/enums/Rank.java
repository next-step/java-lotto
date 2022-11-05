package lotto.enums;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIFTH(3, BigDecimal.valueOf(5000)),
    FOURTH(4, BigDecimal.valueOf(50000)),
    THIRD(5, BigDecimal.valueOf(1500000)),
    SECOND(5, BigDecimal.valueOf(30000000)),
    FIRST(6, BigDecimal.valueOf(2000000000));


    int countsOfSameNumbers;
    BigDecimal rewards;

    Rank(int countsOfSameNumbers, BigDecimal rewards) {
        this.countsOfSameNumbers = countsOfSameNumbers;
        this.rewards = rewards;
    }

    public static Long totalWinningCount() {
        return Arrays.stream(values()).count();
    }

    public int getCountsOfSameNumbers() {
        return this.countsOfSameNumbers;
    }

    public BigDecimal getRewards() {
        return this.rewards;
    }
}

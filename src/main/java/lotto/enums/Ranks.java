package lotto.enums;

import java.math.BigDecimal;

public enum Ranks {
    FIFTH(3, BigDecimal.valueOf(5000)),
    FOURTH(4, BigDecimal.valueOf(50000)),
    THIRD(5, BigDecimal.valueOf(1500000)),
    SECOND(5, BigDecimal.valueOf(30000000)),
    FIRST(6, BigDecimal.valueOf(2000000000));


    private final int countsOfSameNumbers;
    private final BigDecimal rewards;

    Ranks(int countsOfSameNumbers, BigDecimal rewards) {
        this.countsOfSameNumbers = countsOfSameNumbers;
        this.rewards = rewards;
    }

    public int getCountsOfSameNumbers() {
        return this.countsOfSameNumbers;
    }

    public BigDecimal getRewards() {
        return this.rewards;
    }
}

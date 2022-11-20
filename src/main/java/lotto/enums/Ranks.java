package lotto.enums;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Ranks {
    MISS(0, BigDecimal.ZERO, false),
    FIFTH(3, BigDecimal.valueOf(5000), false),
    FOURTH(4, BigDecimal.valueOf(50000), false),
    THIRD(5, BigDecimal.valueOf(1500000), false),
    SECOND(5, BigDecimal.valueOf(30000000), true),
    FIRST(6, BigDecimal.valueOf(2000000000), false);


    private final int countsOfSameNumbers;
    private final BigDecimal rewards;
    private final boolean checkBonusNumber;

    Ranks(int countsOfSameNumbers, BigDecimal rewards, boolean checkBonusNumber) {
        this.countsOfSameNumbers = countsOfSameNumbers;
        this.rewards = rewards;
        this.checkBonusNumber = checkBonusNumber;
    }

    public int getCountsOfSameNumbers() {
        return this.countsOfSameNumbers;
    }

    public BigDecimal getRewards() {
        return this.rewards;
    }

    public static Ranks getRank(int countsOfSameNumbers, boolean containBonusNumber) {
        return Arrays.stream(Ranks.values()).filter(rank -> {
            if(containBonusNumber) {
                return rank.countsOfSameNumbers == countsOfSameNumbers && rank.checkBonusNumber;
            }
            return rank.countsOfSameNumbers == countsOfSameNumbers;
        }).findFirst().orElse(Ranks.MISS);
    }
}

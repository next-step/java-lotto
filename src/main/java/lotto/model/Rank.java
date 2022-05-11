package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5000),
    FORTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final Number correctCount;
    private final Number prizeMoney;

    Rank(int correctCount, int prizeMoney) {
        this.correctCount = Number.of(correctCount);
        this.prizeMoney = Number.of(prizeMoney);
    }

    public Number getCorrectCount() {
        return this.correctCount;
    }

    public Number getPrizeMoney() {
        return this.prizeMoney;
    }

    public static Rank valueOf(Number correctCount) {
        return Arrays
                .stream(Rank.values())
                .filter(rank -> rank.correctCount.equals(correctCount))
                .findFirst()
                .orElse(MISS);
    }

    public Rank checkBonus(Number bonusNumber, Lotto lotto) {
        if (!this.equals(THIRD)) {
            return this;
        }

        Number correctBonus = lotto.match(List.of(bonusNumber));
        if (correctBonus.equals(Number.of(1L))) {
            return SECOND;
        }

        return this;
    }
}

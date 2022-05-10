package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

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
}

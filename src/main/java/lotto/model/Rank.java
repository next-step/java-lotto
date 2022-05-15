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
                .filter(rank -> !rank.equals(THIRD))
                .filter(rank -> rank.correctCount.equals(correctCount))
                .findFirst()
                .orElse(MISS);
    }

    public Rank checkBonus(Number bonusNumber, Lotto lotto) {
        Number correctBonus = lotto.match(List.of(bonusNumber));
        if (this.equals(FORTH) && correctBonus.equals(Number.of(1L))) {
            return THIRD;
        }

        return this;
    }

    public Number getTotalCorrectCount(List<Rank> ranks) {
        long count = ranks
                .stream()
                .filter(this::equals)
                .count();

        return Number.of(count);
    }

    public Number getTotalPrizeMoney(List<Rank> ranks) {
        long count = ranks
                .stream()
                .filter(this::equals)
                .count();

        return Number.of(count).multiply(this.prizeMoney);
    }
}

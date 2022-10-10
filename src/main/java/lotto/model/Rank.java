package lotto.model;

import java.util.Arrays;

public enum Rank {

    NONE(new Money(0), 0),
    FOURTH(new Money(5_000), 3),
    THIRD(new Money(50_000), 4),
    SECOND(new Money(1_500_000), 5),
    FIRST(new Money(2_000_000_000), 6);

    public static final Rank[] values = values();
    private final Money reward;
    private final int correctCount;

    Rank(Money reward, int correctCount) {
        this.reward = reward;
        this.correctCount = correctCount;
    }

    public static Rank findRank(int correctCount) {
        return Arrays.stream(values)
                .filter(rank -> rank.correctCount == correctCount)
                .findFirst()
                .orElse(Rank.NONE);
    }

    public Money getReward() {
        return reward;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}

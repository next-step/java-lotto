package step2.domain.enums;

import java.util.EnumSet;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    SECOND(5, 3_000_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int correctCount;
    private final int prizeMoney;

    Rank(int correctCount, int money) {
        this.correctCount = correctCount;
        this.prizeMoney = money;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank of(int correctCount, boolean isCorrectBonusNumber) {
        if (isCorrectBonusNumber && correctCount == SECOND.getCorrectCount()) {
            return SECOND;
        }

        return findFromCount(correctCount);
    }

    private static Rank findFromCount(int correctCount) {
        return EnumSet.allOf(Rank.class).stream()
                .filter(r -> r.getCorrectCount() == correctCount)
                .findFirst()
                .get();
    }
}

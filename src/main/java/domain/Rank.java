package domain;

import java.util.Arrays;

public enum Rank {
    FAIL(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int prize;
    private final int mathCount;

    Rank(int prize, int mathCount) {
        this.prize = prize;
        this.mathCount = mathCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getMathCount() {
        return mathCount;
    }

    public static Rank getRank(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(prize -> prize.isMatchCount(matchCount))
                .findFirst()
                .orElse(FAIL);
    }

    private boolean isMatchCount(int mathCount) {
        return this.mathCount == mathCount;
    }
}

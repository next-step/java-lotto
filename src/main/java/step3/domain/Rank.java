package step3.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final Integer matchCount;
    private final Integer prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank of(MatchResult matchResult) {
        if (matchResult.isSecond()) {
            return SECOND;
        }
        return Arrays.stream(values())
            .filter(rank -> rank != SECOND && matchResult.verifyMatchCount(rank.matchCount))
            .findFirst()
            .orElse(MISS);
    }

    public int matchCount() {
        return matchCount;
    }

    public int prize() {
        return calculateTotalPrizeByCount(1);
    }

    public int calculateTotalPrizeByCount(int count) {
        return count * prize;
    }
}

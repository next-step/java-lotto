package step4.domain;

import java.math.BigInteger;
import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final Integer matchCount;
    private final Amount prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = new Amount(prize);
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

    public BigInteger parsePrizeIntoBigInteger() {
        return prize.getAmount();
    }

    public Amount calculateTotalPrizeByCount(int count) {
        return prize.multiplyByCount(count);
    }
}

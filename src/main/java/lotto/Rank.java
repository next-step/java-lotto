package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    MISS(0, false, 0, "");

    private final int matchCount;
    private final boolean bonusMatched;
    private final long prize;
    private final String description;

    Rank(int matchCount, boolean bonusMatched, long prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.description = description;
    }

    public long prize() {
        return prize;
    }

    public String description() {
        return description;
    }

    public boolean isWinning() {
        return this != MISS;
    }

    public static Rank of(MatchResult result) {
        return Arrays.stream(values())
            .filter(r -> r.matchCount == result.matchCount())
            .filter(r -> r.bonusMatched == result.bonusMatched())
            .findFirst()
            .orElseGet(() -> Arrays.stream(values())
                .filter(r -> r.matchCount == result.matchCount())
                .filter(r -> !r.bonusMatched)
                .findFirst()
                .orElse(MISS));
    }

    public static Rank[] winningRanks() {
        return Arrays.stream(values()).filter(Rank::isWinning).toArray(Rank[]::new);
    }
}

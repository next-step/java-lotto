package lotto;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치", 5),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치", 4),
    THIRD(5, false, 1_500_000, "5개 일치", 3),
    FOURTH(4, false, 50_000, "4개 일치", 2),
    FIFTH(3, false, 5_000, "3개 일치", 1),
    MISS(0, false, 0, "", 99);

    private final int matchCount;
    private final boolean bonusMatched;
    private final long prize;
    private final String description;
    private final int displayOrder;

    Rank(int matchCount, boolean bonusMatched, long prize, String description, int displayOrder) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.description = description;
        this.displayOrder = displayOrder;
    }

    public long prize() {
        return prize;
    }

    public String description() {
        return description;
    }

    public int displayOrder() {
        return displayOrder;
    }

    public boolean isWinning() {
        return this != MISS;
    }

    public static Rank of(int matchCount, boolean bonusMatched) {
        return Arrays.stream(values())
            .filter(r -> r.matchCount == matchCount)
            .filter(r -> r.bonusMatched == bonusMatched)
            .findFirst()
            .orElseGet(() -> fallbackWithoutBonus(matchCount));
    }

    public static Rank[] winningRanks() {
        return Arrays.stream(values())
            .filter(Rank::isWinning)
            .toArray(Rank[]::new);
    }

    private static Rank fallbackWithoutBonus(int matchCount) {
        return Arrays.stream(values())
            .filter(r -> r.matchCount == matchCount)
            .filter(r -> !r.bonusMatched)
            .findFirst()
            .orElse(MISS);
    }
}

package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 3_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchedCount;
    private final int price;
    private final boolean bonusMatched;

    Rank(int matchedCount, int price, boolean bonusMatched) {
        this.matchedCount = matchedCount;
        this.price = price;
        this.bonusMatched = bonusMatched;
    }

    public static Rank from(int matchedCount, boolean isMatchBonus) {
        return find(matchedCount, isMatchBonus);
    }

    private static Rank find(int matchedCount, boolean isMatchBonus) {
        return Arrays.stream(values())
                     .filter(rank -> rank.matchedCount == matchedCount && rank.bonusMatched == isMatchBonus)
                     .findFirst()
                     .orElse(Rank.MISS);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}

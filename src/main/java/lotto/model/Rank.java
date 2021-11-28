package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 3_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final int SECOND_OR_THIRD_COUNT = 5;

    private final int matchedCount;
    private final int price;

    private Rank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static Rank from(int matchedCount, boolean isMatchBonus) {
        return find(matchedCount, isMatchBonus);
    }

    private static Rank find(int matchedCount, boolean isMatchBonus) {
        Rank rank = getRank(matchedCount);
        if (isThird(matchedCount, isMatchBonus)) {
            return THIRD;
        }
        return rank;
    }

    private static Rank getRank(int matchedCount) {
        return Arrays.stream(values())
                     .filter(rank -> rank.matchedCount == matchedCount)
                     .findFirst()
                     .orElse(MISS);
    }

    private static boolean isThird(int matchedCount, boolean isMatchBonus) {
        return matchedCount == SECOND_OR_THIRD_COUNT && !isMatchBonus;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }
}

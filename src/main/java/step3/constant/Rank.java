package step3.constant;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private Integer matchedCount;
    private Integer winnerPrice;

    private Rank(Integer matchedCount, Integer winnerPrice) {
        this.matchedCount = matchedCount;
        this.winnerPrice = winnerPrice;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public Integer winnerPrice() {
        return winnerPrice;
    }

    public static Rank findRankPriceBymatchedCount(Integer count,
            boolean bonusNumber) {
        Rank rank = Arrays.stream(values())
            .filter(winnerPrice -> winnerPrice.matchedCount == count)
            .findFirst().orElse(NONE);

        if (rank.matchedCount == 5 && !bonusNumber) {
            return THIRD;
        }

        return rank;
    }

}

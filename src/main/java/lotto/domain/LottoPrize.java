package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int matchCount;
    private int price;

    LottoPrize(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static LottoPrize find(int count) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == count)
                .findFirst()
                .orElse(LottoPrize.NONE);
    }
}

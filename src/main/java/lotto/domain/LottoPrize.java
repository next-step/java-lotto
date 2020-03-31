package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

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

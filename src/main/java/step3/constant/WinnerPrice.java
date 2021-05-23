package step3.constant;

import java.util.Arrays;

public enum WinnerPrice {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private Integer matchedCount;
    private Integer winnerPrice;

    private WinnerPrice(Integer matchedCount, Integer winnerPrice) {
        this.matchedCount = matchedCount;
        this.winnerPrice = winnerPrice;
    }

    public Integer matchedCount() {
        return matchedCount;
    }

    public Integer winnerPrice() {
        return winnerPrice;
    }

    public static WinnerPrice findWinnerPriceBymatchedCount(Integer count) {
        return Arrays.stream(values())
            .filter(winnerPrice -> winnerPrice.matchedCount == count)
            .findFirst().orElse(NONE);
    }

}

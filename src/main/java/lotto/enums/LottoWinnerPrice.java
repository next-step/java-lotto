package lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinnerPrice {
    NONE_RANK(0, 0),
    FOURTH_RANK(3, 5000),
    THIRD_RANK(4, 50000),
    SECOND_RANK(5, 1500000),
    FIRST_RANK(6, 2000000000);

    private final int matchedCount;
    private final int price;

    LottoWinnerPrice(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public static int getPrice(int matchedCount) {
        return Arrays.stream(LottoWinnerPrice.values())
                .filter(price -> price.matchedCount == matchedCount)
                .findFirst()
                .orElse(NONE_RANK)
                .getPrice();
    }

    public static List<LottoWinnerPrice> getLottoWinnerPrice() {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE_RANK)
                .collect(Collectors.toUnmodifiableList());
    }
}

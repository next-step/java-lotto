package lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoWinnerPrice {
    none_rank(0, 0),
    fourth_rank(3, 5000),
    third_rank(4, 50000),
    second_rank(5, 1500000),
    first_rank(6, 2000000000);

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
                .filter(s -> s.matchedCount == matchedCount)
                .findFirst()
                .orElse(none_rank)
                .getPrice();
    }

    public static List<LottoWinnerPrice> getLottoWinnerPrice() {
        return Arrays.stream(values())
                .filter(s -> s != none_rank)
                .collect(Collectors.toUnmodifiableList());
    }
}

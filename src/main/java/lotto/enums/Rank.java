package lotto.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    NONE_RANK(0, 0),
    FIFTH_RANK(3, 5000),
    FOURTH_RANK(4, 50000),
    THIRD_RANK(5, 1500000),
    SECOND_RANK(5, 30000000),
    FIRST_RANK(6, 2000000000);

    private final int matchedCount;
    private final int price;

    Rank(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }

    public static Rank getRank(int matchedCount, boolean isMatchBonus) {
        if (matchedCount == 5 && isMatchBonus) {
            return SECOND_RANK;
        }
        return Arrays.stream(Rank.values())
                .filter(price -> price.matchedCount == matchedCount)
                .findFirst()
                .orElse(NONE_RANK);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public int getPrice() {
        return price;
    }

    public static List<Rank> getLottoWinnerPrice() {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE_RANK)
                .collect(Collectors.toUnmodifiableList());
    }
}

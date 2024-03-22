package lotto.domain;

import java.util.Arrays;

public enum Prize {

    NONE(0, 0),
    FOURTH_PRIZE(3, 5_000),
    THIRD_PRIZE(4, 50_000),
    SECOND_PRIZE(5, 1_500_000),
    FIRST_PRIZE(6, 2_000_000_000);

    private final int price;
    private final int matchCount;

    Prize(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static Prize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(p -> p.isSame(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public boolean containsPrize() {
        return FOURTH_PRIZE.matchCount <= matchCount && matchCount <= FIRST_PRIZE.matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    private boolean isSame(int matchCount) {
        return this.matchCount == matchCount;
    }

}

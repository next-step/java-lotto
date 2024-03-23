package lotto.model;

import java.util.Arrays;

public enum PrizeEnum {

    THREE_MATCHED(3, 5000),
    FOUR_MATCHED(4, 50000),
    FIVE_MATCHED(5, 1500000),
    SIX_MATCHED(6, 2000000000),
    NONE(0, 0)
    ;

//    NONE(0, 0),
//    FOURTH_PRIZE(3, 5000),
//    THIRD_PRIZE(4, 50000),
//    SECOND_PRIZE(5, 1500000),
//    FIRST_PRIZE(6, 2000000000);

    private final int price;
    private final int matchCount;

    PrizeEnum(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static PrizeEnum valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(p -> p.isSame(matchCount))
                .findFirst()
                .orElse(NONE);
    }

    public boolean containsPrize() {
        return THREE_MATCHED.matchCount <= matchCount && matchCount <= SIX_MATCHED.matchCount;
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

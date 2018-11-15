package lotto.model;

import java.util.Arrays;

public enum PrizePrice {
    MATCH_ZERO(0),
    MATCH_ONE(0),
    MATCH_TWO(0),
    MATCH_THREE(5000),
    MATCH_FOUR(50000),
    MATCH_FIVE(1500000),
    MATCH_SIX(2000000000);

    private int price;

    PrizePrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static int getPrice(int index) {
        return valueOf(index).price;
    }

    public static PrizePrice valueOf(int index) {
        return Arrays.stream(PrizePrice.values())
                .filter(prizePrice -> prizePrice.ordinal() == index)
                .findFirst()
                .get();
    }
}

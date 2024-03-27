package lotto.domain;

import java.util.Arrays;

public enum LottoPrice {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    NO(0, 0);

    private int count;
    private int price;

    LottoPrice(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static LottoPrice findPrice(int count) {
        return Arrays.stream(LottoPrice.values()).filter(item -> item.getCount() == count).findAny()
            .orElse(NO);
    }

}

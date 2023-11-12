package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum CountPrice {
    SIX_PRICE(6, new BigDecimal("2000000000")),
    FIVE_PRICE(5, new BigDecimal("1500000")),
    FOUR_PRICE(4, new BigDecimal("50000")),
    THIRD_PRICE(3, new BigDecimal("5000"));
    public static final String INVALID_COUNT = "올바른 갯수가 아닙니다.";
    private int count;
    private BigDecimal price;

    CountPrice(final int count, final BigDecimal price) {
        this.count = count;
        this.price = price;
    }

    static BigDecimal priceOfCount(int count) {
        return Arrays.stream(values())
                .filter(v -> v.count == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT)).price;
    }
}

package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, new BigDecimal("2_000_000_000")),
    SECOND(5, new BigDecimal("30_000_000")),
    THIRD(5, new BigDecimal("1_500_000")),
    FOURTH(4, new BigDecimal("50_000")),
    FIFTH(3, new BigDecimal("5_000")),
    MISS(0, BigDecimal.ZERO);

    public static final String INVALID_COUNT = "올바른 갯수가 아닙니다.";
    private int count;
    private BigDecimal price;

    Rank(final int count, final BigDecimal price) {
        this.count = count;
        this.price = price;
    }

    static BigDecimal priceOf(int count) {
        return Arrays.stream(values())
                .filter(v -> v.count == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COUNT)).price;
    }
}

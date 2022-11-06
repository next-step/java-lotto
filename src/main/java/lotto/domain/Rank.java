package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Rank {
    FIRST(6, BigDecimal.valueOf(2000000000)),
    SECOND(5, BigDecimal.valueOf(1500000)),
    THIRD(4, BigDecimal.valueOf(50000)),
    FORTH(3, BigDecimal.valueOf(5000)),
    FIFTH(2, BigDecimal.valueOf(0)),
    SIXTH(1, BigDecimal.valueOf(0)),
    ZERO(0, BigDecimal.valueOf(0));

    private final int count;
    private final BigDecimal amount;

    Rank(int count, BigDecimal amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public static Rank getRank(int count) {
        return Arrays.stream(values())
                .filter(cnt -> cnt.getCount() == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자가 틀립니다."));
    }
}

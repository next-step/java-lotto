package lotto.entity;

import java.math.BigDecimal;


public enum PrizeMoney {
    LOSE(0, null),
    THREE(3, BigDecimal.valueOf(5000)),
    FOUR(4, BigDecimal.valueOf(50000)),
    FIVE(5, BigDecimal.valueOf(1500000)),
    SIX(6, BigDecimal.valueOf(2000000000));

    private final int count;
    private final BigDecimal prizeMoney;

    PrizeMoney(int count, BigDecimal prizeMoney) {
        this.count = count;
        this.prizeMoney = prizeMoney;
    }

    public boolean isMatch(int count) {
        return this.count == count;
    }

    public boolean isWinner() {
        return this.prizeMoney != null;
    }

    public BigDecimal sum(BigDecimal winner) {
        return this.prizeMoney.add(winner);
    }
}

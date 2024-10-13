package lotto.entity;

import java.math.BigDecimal;


public enum PrizeMoney {
    LOSE(0, BigDecimal.valueOf(0)),
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

    public static PrizeMoney findByCount(int count) {
        if (count == PrizeMoney.THREE.count) {
            return PrizeMoney.THREE;
        }
        if (count == PrizeMoney.FOUR.count) {
            return PrizeMoney.FOUR;
        }
        if (count == PrizeMoney.FIVE.count) {
            return PrizeMoney.FIVE;
        }
        if (count == PrizeMoney.SIX.count) {
            return PrizeMoney.SIX;
        }
        return PrizeMoney.LOSE;
    }

    public BigDecimal sum(BigDecimal winner) {
        return this.prizeMoney.add(winner);
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}

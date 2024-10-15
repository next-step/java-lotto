package lotto.entity;

import java.math.BigDecimal;


public enum PrizeMoney {
    LOSE(0, BigDecimal.valueOf(0)),
    THREE(3, BigDecimal.valueOf(5000)),
    FOUR(4, BigDecimal.valueOf(50000)),
    FIVE(5, BigDecimal.valueOf(1500000)),
    SIX(6, BigDecimal.valueOf(2000000000));

    private final int collectCount;
    private final BigDecimal prizeMoney;

    PrizeMoney(int collectCount, BigDecimal prizeMoney) {
        this.collectCount = collectCount;
        this.prizeMoney = prizeMoney;
    }

    public static PrizeMoney findByCount(int collectCount) {
        if (collectCount == PrizeMoney.THREE.collectCount) {
            return PrizeMoney.THREE;
        }
        if (collectCount == PrizeMoney.FOUR.collectCount) {
            return PrizeMoney.FOUR;
        }
        if (collectCount == PrizeMoney.FIVE.collectCount) {
            return PrizeMoney.FIVE;
        }
        if (collectCount == PrizeMoney.SIX.collectCount) {
            return PrizeMoney.SIX;
        }
        return PrizeMoney.LOSE;
    }

    public BigDecimal sum(BigDecimal winner) {
        return this.prizeMoney.add(winner);
    }

    public int getCollectCount() {
        return collectCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}

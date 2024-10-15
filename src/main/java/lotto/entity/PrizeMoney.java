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
        PrizeMoney result = PrizeMoney.LOSE;
        for (PrizeMoney prizeMoney : PrizeMoney.values()) {
            result = winning(result, prizeMoney, collectCount);
        }
        return result;
    }

    private static PrizeMoney winning(PrizeMoney result, PrizeMoney prizeMoney, int collectCount) {
        if (result != PrizeMoney.LOSE) {
            return result;
        }
        return prizeMoney.collectCount == collectCount ? prizeMoney : PrizeMoney.LOSE;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }
}

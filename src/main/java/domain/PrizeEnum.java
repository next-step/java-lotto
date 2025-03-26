package domain;

import java.math.BigDecimal;

public enum PrizeEnum {

    THREE_HIT(3L, BigDecimal.valueOf(5_000)),
    FOUR_HIT(4L, BigDecimal.valueOf(50_000)),
    FIVE_HIT(5L, BigDecimal.valueOf(1_500_000)),
    SIX_HIT(6L, BigDecimal.valueOf(2_000_000_000)),
    ;

    private final long hit;
    private final BigDecimal prizeAmt;

    PrizeEnum(long hit, BigDecimal prizeAmt) {
        this.hit = hit;
        this.prizeAmt = prizeAmt;
    }

    public long getHit() {
        return hit;
    }

    public BigDecimal getPrizeAmt() {
        return prizeAmt;
    }
}

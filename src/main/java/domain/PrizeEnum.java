package domain;

import java.math.BigDecimal;

public enum PrizeEnum {
    THREE_HIT(3L, BigDecimal.valueOf(5_000)),
    FOUR_HIT(4L, BigDecimal.valueOf(50_000)),
    FIVE_HIT(5L, BigDecimal.valueOf(1_500_000)),
    FIVE_HIT_BONUS_HIT(5L, BigDecimal.valueOf(30_000_000)),
    SIX_HIT(6L, BigDecimal.valueOf(2_000_000_000)),
    ;

    private final long hit;
    private final BigDecimal prizeAmt;

    PrizeEnum(long hit, BigDecimal prizeAmt) {
        this.hit = hit;
        this.prizeAmt = prizeAmt;
    }

    public long getHit() {
        return this.hit;
    }

    public BigDecimal getPrizeAmt() {
        return prizeAmt;
    }

    public static PrizeEnum of(long hit, boolean matchBonus) {
        for (PrizeEnum prizeEnum : values()) {
            if (prizeEnum.hit == hit) {
                return getPrizeEnum(hit, matchBonus, prizeEnum);
            }
        }
        return null;
    }

    private static PrizeEnum getPrizeEnum(long hit, boolean matchBonus, PrizeEnum prizeEnum) {
        if(hit == 5L && matchBonus){
            return PrizeEnum.FIVE_HIT_BONUS_HIT;
        }
        return prizeEnum;
    }

}

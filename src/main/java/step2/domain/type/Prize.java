package step2.domain.type;

import java.math.BigDecimal;

public enum Prize {

    THREE(3, BigDecimal.valueOf(5000)),
    FOUR(4, BigDecimal.valueOf(50000)),
    FIVE(5, BigDecimal.valueOf(1500000)),
    SIX(6, BigDecimal.valueOf(2000000000));

    private int matchCount;
    private BigDecimal prizeMoney;

    Prize(int matchCount, BigDecimal prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int matchCount() {
        return this.matchCount;
    }

    public BigDecimal prizeMoney() {
        return this.prizeMoney;
    }

}

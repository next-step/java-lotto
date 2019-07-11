package lottogame.domain;

import java.math.BigDecimal;

public class LottoRevenue {
    private final static BigDecimal PROFIT_RANGE = new BigDecimal(1.00);

    final private BigDecimal revenue;

    LottoRevenue(BigDecimal revenue) {
        this.revenue = revenue;

    }

    public String judgeResult() {
        if (this.revenue.compareTo(PROFIT_RANGE) > 0)
            return "이익";
        if (this.revenue.equals(PROFIT_RANGE))
            return "본전";
        return "손해";
    }

    public BigDecimal getRevenue() {
        return revenue;
    }
}

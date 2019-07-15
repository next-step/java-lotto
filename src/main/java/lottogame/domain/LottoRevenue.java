package lottogame.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class LottoRevenue {
    private final static BigDecimal PROFIT_RANGE = new BigDecimal(1.00);
    private final static String PATTERN = "#.##";

    final private BigDecimal revenue;
    final private DecimalFormat form = new DecimalFormat(PATTERN);

    LottoRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public boolean isRevenueOverProfitRange() {
        if (this.revenue.compareTo(PROFIT_RANGE) > 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "총 수익률은  " + form.format(getRevenue()) + "입니다. (기준이 1이기 때문에 결과적으로 ";
    }
}

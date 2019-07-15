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

    private String judgeResult() {
        if (this.revenue.compareTo(PROFIT_RANGE) > 0)
            return "이익";
        if (this.revenue.equals(PROFIT_RANGE))
            return "본전";
        return "손해";
    }

    @Override
    public String toString() {
        return "총 수익률은  " + form.format(getRevenue()) + "입니다. (기준이 1이기 때문에 결과적으로 " + judgeResult() + "라는 의미임)";
    }
}

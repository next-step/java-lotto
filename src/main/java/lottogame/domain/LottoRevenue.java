package lottogame.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class LottoRevenue {
    private final static BigDecimal PROFIT_RANGE = new BigDecimal(1.00);
    private final static String PATTERN = "#.##";
    private final static int EQUAL_STATUS = 0;

    final private BigDecimal revenue;
    final private DecimalFormat form = new DecimalFormat(PATTERN);

    LottoRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public boolean isRevenueOverProfitRange() {
        if (this.revenue.compareTo(PROFIT_RANGE) > EQUAL_STATUS)
            return true;
        return false;
    }

    public boolean isEqualWithProfitRange() {
        return revenue.compareTo(PROFIT_RANGE) == EQUAL_STATUS;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LottoRevenue other = (LottoRevenue) obj;
        if (revenue == null) {
            if (other.revenue != null)
                return false;
        } else if (!revenue.equals(other.revenue))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "총 수익률은  " + form.format(getRevenue()) + "입니다. (기준이 1이기 때문에 결과적으로 ";
    }
}

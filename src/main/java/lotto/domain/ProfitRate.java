package lotto.domain;

import java.math.BigDecimal;

public class ProfitRate {

    public static final String DECIMAL_TWO_POINT = "%.2f";
    public static final double REFERENCE_RATIO = 1.0;

    private final String profitRate;

    private ProfitRate(final String profitRate){

        this.profitRate = profitRate;
    }

    public static ProfitRate of(final BigDecimal price, final Purchase purchase) {

        final double result = price.doubleValue() / purchase.getPurchase();
        return new ProfitRate(String.format(DECIMAL_TWO_POINT, result));
    }

    public boolean canProfit() {

        return Double.parseDouble(this.profitRate) >= REFERENCE_RATIO;
    }

    public String getProfitRate() {

        return profitRate;
    }
}

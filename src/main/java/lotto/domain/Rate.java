package lotto.domain;

import java.math.BigDecimal;

public class Rate {

    private static final double DEFAULT_PRIZE_MONEY = 0;
    private static final int SCALE = 2;

    private BigDecimal rate;

    private Rate(BigDecimal rate) {
        this.rate = rate;
    }

    public static Rate of(double money, double prizeMoney) {
        BigDecimal rate = BigDecimal.valueOf(prizeMoney);
        if (prizeMoney == DEFAULT_PRIZE_MONEY) {
            return new Rate(rate);
        }

        rate = rate.divide(BigDecimal.valueOf(money), SCALE, BigDecimal.ROUND_FLOOR);
        return new Rate(rate);
    }

    public double getRate() {
        return rate.doubleValue();
    }
}

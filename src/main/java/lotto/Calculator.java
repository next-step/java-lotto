package lotto;

import java.math.BigDecimal;

public class Calculator {
    public double calculateYield(BigDecimal purchaseAmount, BigDecimal prizeMoney) {
        double earnedMoney = prizeMoney.subtract(purchaseAmount).doubleValue();
        return 1 + (earnedMoney / purchaseAmount.doubleValue());
    }
}

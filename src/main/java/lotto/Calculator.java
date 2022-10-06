package lotto;

import java.math.BigDecimal;
import java.util.Map;

public class Calculator {
    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);

    public double calculateYield(BigDecimal purchaseAmount, BigDecimal prizeMoney) {
        double earnedMoney = prizeMoney.subtract(purchaseAmount).doubleValue();
        return 1 + (earnedMoney / purchaseAmount.doubleValue());
    }

    public BigDecimal calculatePurchaseAmount(int purchaseCount) {
        return PRICE_PER_LOTTO.multiply(BigDecimal.valueOf(purchaseCount));
    }

    public BigDecimal calculatePrizeMoney(Map<Integer, Integer> rankMap) {
        BigDecimal prizeMoney = BigDecimal.ZERO;

        for (Prize value : Prize.values()) {
            prizeMoney = prizeMoney.add(
                    BigDecimal.valueOf(rankMap.get(value.getWinningCount())).multiply(value.getPrizeMoney()));
        }

        return prizeMoney;
    }
}

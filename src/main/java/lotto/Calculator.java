package lotto;

import java.math.BigDecimal;
import java.util.Map;

import lotto.domain.Prize;

public class Calculator {
    private static final BigDecimal PRICE_PER_LOTTO = BigDecimal.valueOf(1000);

    public double calculateYield(BigDecimal purchaseAmount, BigDecimal prizeMoney) {
        double earnedMoney = prizeMoney.subtract(purchaseAmount).doubleValue();
        return 1 + (earnedMoney / purchaseAmount.doubleValue());
    }

    public int calculatePurchasedLottoNum(BigDecimal payAmount) {
        return payAmount.divide(PRICE_PER_LOTTO).intValue();
    }

    public BigDecimal calculatePrizeMoney(Map<Prize, Integer> rankMap) {
        BigDecimal prizeMoney = BigDecimal.ZERO;

        for (Prize value : Prize.values()) {
            BigDecimal bigDecimal = BigDecimal.valueOf(rankMap.get(value));
            prizeMoney = prizeMoney.add(bigDecimal.multiply(value.getPrizeMoney()));
        }

        return prizeMoney;
    }
}

package autoLotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoProfitChecker {
    private static final Long ZERO_PURCHASE_AMOUNT = 0L;
    private BigDecimal profit;

    public LottoProfitChecker(Map<PrizeEnum, Integer> winLottos) {
        this.profit = getTotalPrizes(winLottos);
    }

    private BigDecimal getTotalPrizes(Map<PrizeEnum, Integer> winLottos) {
        BigDecimal totalWinAmount = BigDecimal.ZERO;

        for (PrizeEnum prize : winLottos.keySet()) {
            BigDecimal prizeResult = BigDecimal.valueOf(prize.getPrize() * winLottos.get(prize));
            totalWinAmount = totalWinAmount.add(prizeResult);
        }

        return totalWinAmount;
    }

    public BigDecimal getProfitRatio(Long purchaseAmount) {
        if (purchaseAmount.equals(ZERO_PURCHASE_AMOUNT)) {
            return BigDecimal.ZERO;
        }

        return calculateProfitRatio(BigDecimal.valueOf(purchaseAmount));
    }

    private BigDecimal calculateProfitRatio(BigDecimal purchaseAmount) {
        return profit.divide(purchaseAmount, 2, RoundingMode.DOWN);
    }
}

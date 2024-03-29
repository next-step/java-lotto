package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoProfit {
    private static final int ZERO_PURCHASE_AMOUNT = 0;
    private static final int KOREAN_DOLLAR_UNIT = 1000;
    private BigDecimal profit;

    public LottoProfit(Map<PrizeEnum, Integer> winLottos) {
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

    public BigDecimal getProfitRatio(PurchaseAmount purchaseAmount) {
        if (purchaseAmount.getPurchaseAmount() == ZERO_PURCHASE_AMOUNT) {
            return BigDecimal.ZERO;
        }

        return calculateProfitRatio(BigDecimal.valueOf(purchaseAmount.getPurchaseAmount()));
    }

    private BigDecimal calculateProfitRatio(BigDecimal purchaseAmount) {
        return profit.divide(purchaseAmount, 2, RoundingMode.DOWN);
    }
}

package autoLotto.model;

import java.util.Map;

public class LottoProfitChecker {
    private static final Long INIT_BENEFIT = 0L;

    private Long profit;

    public LottoProfitChecker(Map<Integer, Integer> winLottos) {
        this.profit = getTotalPrizes(winLottos);
    }

    private Long getTotalPrizes(Map<Integer, Integer> winLottos) {
        Long totalWinAmount = INIT_BENEFIT;

        for (Integer key : winLottos.keySet()) {
            totalWinAmount += (getPrizeAmount(key) * winLottos.get(key));
        }

        return totalWinAmount;
    }

    private Long getPrizeAmount(int index) {
        return PrizeResultEnum.getPrizeByMatchedCount(index);
    }

    public float getProfitRatio(Long purchaseAmount) {
        return calculateProfitRatio(purchaseAmount);
    }

    private float calculateProfitRatio(float purchaseAmount) {
        if (purchaseAmount == INIT_BENEFIT) {
            return 0f;
        }

        float profitRatio = profit / purchaseAmount;
        return profitRatio;
    }
}

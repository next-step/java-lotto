package autoLotto.model;

import java.util.HashMap;

public class LottoProfitChecker {
    private static final Long INIT_BENEFIT = 0L;

    private Long profit;

    public LottoProfitChecker(HashMap<Integer, Integer> winLottos) {
        this.profit = getTotalPrizes(winLottos);
    }

    private Long getTotalPrizes(HashMap<Integer, Integer> winLottos) {
        Long totalWinAmount = INIT_BENEFIT;

        for (Integer key : winLottos.keySet()) {
            totalWinAmount += (getPrizeAmount(key) * winLottos.get(key));
        }

        return totalWinAmount;
    }

    private Long getPrizeAmount(int index) {
        return PrizeResultEnum.getPrizeByIndex(index);
    }

    public float getProfitRatio(String purchaseAmount) {
        float purchaseAmountAsFloat = stringToFloat(purchaseAmount);
        return calculateProfitRatio(purchaseAmountAsFloat);
    }

    private float calculateProfitRatio(float purchaseAmount) {
        if (purchaseAmount == INIT_BENEFIT) {
            return 0f;
        }

        float profitRatio = profit / purchaseAmount;
        return profitRatio;
    }

    private float stringToFloat(String string) {
        return Float.parseFloat(string);
    }

}

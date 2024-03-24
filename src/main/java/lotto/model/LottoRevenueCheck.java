package lotto.model;

import java.util.Map;

public class LottoRevenueCheck {
    private int revenue;

    public LottoRevenueCheck(Map<Integer, Integer> winLottos) {
        this.revenue = getTotalPrice(winLottos);
    }

    private int getTotalPrice(Map<Integer, Integer> winLottos) {
        int totalWinAmount = 0;

        for (Integer key : winLottos.keySet()) {
            totalWinAmount += (getPrizeAmount(key) * winLottos.get(key));
        }

        return totalWinAmount;
    }

    private int getPrizeAmount(int count) {
        return LottoRank.getPrice(count);
    }

    public float getRevenueRatio(String purchaseAmount) {
        return calculateRevenueRatio(Float.parseFloat(purchaseAmount));
    }

    private float calculateRevenueRatio(float purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0f;
        }
        return revenue / purchaseAmount;
    }

}

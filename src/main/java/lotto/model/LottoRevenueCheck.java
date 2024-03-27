package lotto.model;

import java.util.Map;

public class LottoRevenueCheck {
    private int revenue;

    public LottoRevenueCheck(Map<Integer, Integer> winLottos) {
        this.revenue = getTotalPrice(winLottos);
    }

    public int getTotalPrice(Map<Integer, Integer> winLottos) {
        int totalWinAmount = 0;

        for (Integer key : winLottos.keySet()) {
            totalWinAmount += (LottoRank.getPrice(key) * winLottos.get(key));
        }

        return totalWinAmount;
    }

    public float getRevenueRatio(String purchaseAmount) {
        return calculateRevenueRatio(Float.parseFloat(purchaseAmount));
    }

    public float calculateRevenueRatio(float purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0f;
        }
        return revenue / purchaseAmount;
    }

}

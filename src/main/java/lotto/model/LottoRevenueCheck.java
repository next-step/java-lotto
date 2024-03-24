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
        //float purchaseAmountAsFloat = stringToFloat(purchaseAmount);
        float purchaseAmountFloat = Float.parseFloat(purchaseAmount);
        return calculateRevenueRatio(purchaseAmountFloat);
    }

    private float calculateRevenueRatio(float purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0f;
        }

        return revenue / purchaseAmount;
    }

//    private float stringToFloat(String string) {
//System.out.println("stringToFloat :" + string);
//        return Float.parseFloat(string);
//    }

}

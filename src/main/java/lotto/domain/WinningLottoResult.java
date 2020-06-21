package lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoResult {

    private List<Prize> rankResult;
    private Map<Prize, Integer> result;

    public WinningLottoResult() {
        rankResult = new ArrayList();
        result = new LinkedHashMap<>();
        result.put(Prize.FOURTH, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.FIRST, 0);

    }

    public void match(int count) {
        if (count > 3) {
            Prize prize = Prize.findByPrize(count);
            rankResult.add(prize);
        }
    }

    public Map<Prize, Integer> getResult() {

        for (Prize prize : this.rankResult) {
            Integer plusCount = result.get(prize) + 1;
            result.put(prize, plusCount);
        }

        return result;
    }


    public float getRevenueStatic(int buyCount) {
        int totalSum = getTotalSum();
        return totalSum / (buyCount * 1000);
    }

    private int getTotalSum() {
        int totalSum = 0;
        for (Prize prize : this.rankResult) {
            totalSum = prize.sumMoney(totalSum);
        }
        return totalSum;
    }

    public String benefitOrLoss(float revenue) {

        if (revenue < 1) {
            return "손해";
        }
        return "이득";
    }


}

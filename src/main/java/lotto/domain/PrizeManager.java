package lotto.domain;

import java.util.Map;

public class PrizeManager {

    private final long prize;

    public PrizeManager(Map<Integer, Integer> results) {
        this.prize = calculate(results);
    }


    private long calculate(Map<Integer, Integer> results){
        long amount = 0L;

        for (Integer value : results.keySet()) {
            int count = results.get(value);

            long prizeAmount = LottoPrize.getWinningAmount(value);

            amount += (count * prizeAmount);
        }

        return amount;
    }

    public double getProfitMargin(int purchaseAmount){
        return (double) prize /purchaseAmount;
    }

}

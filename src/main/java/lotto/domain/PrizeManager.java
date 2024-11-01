package lotto.domain;

import java.util.Map;

public class PrizeManager {

    private final long prize;

    public PrizeManager(Map<LottoRank, Integer> results) {
        this.prize = calculatePrize(results);
    }


    private long calculatePrize(Map<LottoRank, Integer> results){
        long amount = 0L;

        for (LottoRank value : results.keySet()) {
            int count = results.get(value);

            amount += (count * value.getPrizeAmount());
        }

        return amount;
    }

    public double getProfitMargin(int purchaseAmount){
        return (double) prize /purchaseAmount;
    }

}

package lotto.domain;

import java.util.Map;

public class Prize {

    private final long value;

    public Prize(Map<LottoRank, Integer> results) {
        this.value = calculatePrize(results);
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
        return (double) value /purchaseAmount;
    }

}

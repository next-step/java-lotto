package lotto.domian;

import java.util.Map;

public class MultiplyStrategy implements CalculableStrategy {

    @Override
    public ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney) {
        double allPrize = 0;

        for (Map.Entry<Rank, Integer> entry : rankMap.entrySet()) {
            allPrize += entry.getKey().getPrize() * entry.getValue();
        }

        return new ProfitRate(allPrize / purchaseMoney);
    }
}

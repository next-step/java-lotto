package lotto.domain.result;

import java.util.Map;

public class ProfitCalculator {

    private final CalculableProfitRate calculableProfitRate;

    public ProfitCalculator(CalculableProfitRate calculableProfitRate) {
        this.calculableProfitRate = calculableProfitRate;
    }

    public ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney) {
        return calculableProfitRate.calculate(rankMap, purchaseMoney);
    }
}

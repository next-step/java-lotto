package lotto.domain.result;

import java.util.Map;

public class ProfitCalculator {

    private final CalculableStrategy calculableStrategy;

    public ProfitCalculator(CalculableStrategy calculableStrategy) {
        this.calculableStrategy = calculableStrategy;
    }

    public ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney) {
        return calculableStrategy.calculate(rankMap, purchaseMoney);
    }
}

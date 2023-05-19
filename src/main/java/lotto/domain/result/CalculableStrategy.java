package lotto.domain.result;

import java.util.Map;

@FunctionalInterface
public interface CalculableStrategy {

    ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney);
}

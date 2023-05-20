package lotto.domain.result;

import java.util.Map;

@FunctionalInterface
public interface CalculableProfitRate {

    ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney);
}

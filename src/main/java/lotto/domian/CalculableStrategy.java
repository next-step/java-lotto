package lotto.domian;

import java.util.Map;

public interface CalculableStrategy {

    ProfitRate calculate(Map<Rank, Integer> rankMap, int purchaseMoney);
}

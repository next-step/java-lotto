package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoInspector {

    public LottoInspector() {
    }

    public Map<Integer, Integer> getResult(Lotto winningLotto, List<Lotto> lottos) {
        Map<Integer, Integer> matchedResult = new LinkedHashMap<>();
        for (Lotto lotto : lottos) {
            putMatchedResult(matchedResult, winningLotto.getMatchedCount(lotto));
        }
        return matchedResult;
    }

    public int getTotalRevenue(Map<Integer, Integer> result) {
        int totalRevenue = 0;
        for (Integer key : result.keySet()) {
            totalRevenue += RewardEnum.calculateReward(key, result.get(key));
        }
        return totalRevenue;
    }

    public BigDecimal getYield(Money money, int totalRevenue) {
        return new BigDecimal(totalRevenue).divide(new BigDecimal(money.getMoney()), 2, BigDecimal.ROUND_HALF_UP);
    }

    private void putMatchedResult(Map<Integer, Integer> matchedResult, Integer matchedName) {
        if (matchedResult.containsKey(matchedName)) {
            matchedResult.put(matchedName, matchedResult.get(matchedName) + 1);
        }
        matchedResult.put(matchedName, 1);
    }
}

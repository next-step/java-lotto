package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoInspector {

    public LottoInspector() {
    }

    public InsightResults getResult(WinningLotto winningLotto, Lottos lottos) {
        Map<RankEnum, Integer> matchedResult = initMatchedResult();
        for (Lotto lotto : lottos.getLottos()) {
            RankEnum rank = winningLotto.getRank(lotto);
            matchedResult.put(rank, matchedResult.getOrDefault(rank, 0) + 1);
        }
        return new InsightResults(matchedResult);
    }

    private Map<RankEnum, Integer> initMatchedResult() {
        Map<RankEnum, Integer> matchedResult = new LinkedHashMap<>();
        for (RankEnum rank : RankEnum.values()) {
            matchedResult.put(rank, 0);
        }
        return matchedResult;
    }

    public BigDecimal getYield(Money money, int totalRevenue) {
        return new BigDecimal(totalRevenue).divide(new BigDecimal(money.getMoney()), 2, BigDecimal.ROUND_HALF_UP);
    }
}

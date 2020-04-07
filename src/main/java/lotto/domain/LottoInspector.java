package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoInspector {

    public LottoInspector() {
    }

    public InsightResult getResult(WinningLotto winningLotto, Lottos lottos) {
        Map<RankEnum, Integer> matchedResult = initMatchedResult();
        for (Lotto lotto : lottos.getLottos()) {
            int matchedCount = winningLotto.getWinningLotto().getMatchedCount(lotto);
            boolean hasBonus = lotto.isExistNumber(winningLotto.getBonusNumber());
            RankEnum rank = RankEnum.getRank(matchedCount, hasBonus);
            matchedResult.put(rank, matchedResult.getOrDefault(rank, 0) + 1);
        }

        return new InsightResult(matchedResult);
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

package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoInspector {

    public LottoInspector() {
    }

    public Map<RankEnum, Integer> getResult(WinningLotto winningLotto, List<Lotto> lottos) {
        Map<RankEnum, Integer> matchedResult = initMatchedResult();
        for (Lotto lotto : lottos) {
            int matchedCount = winningLotto.getWinningLotto().getMatchedCount(lotto);
            boolean hasBonus = lotto.isExistNumber(winningLotto.getBonusNumber());
            RankEnum rank = RankEnum.getRank(matchedCount, hasBonus);
            matchedResult.put(rank, matchedResult.getOrDefault(rank, 0) + 1);
        }
        return matchedResult;
    }

    private Map<RankEnum, Integer> initMatchedResult() {
        Map<RankEnum, Integer> matchedResult = new LinkedHashMap<>();
        for (RankEnum rank : RankEnum.values()) {
            matchedResult.put(rank, 0);
        }
        return matchedResult;
    }

    public int getTotalRevenue(Map<RankEnum, Integer> result) {
        int totalRevenue = 0;
        for (RankEnum rank : result.keySet()) {
            totalRevenue += rank.getReward() * result.get(rank);
        }
        return totalRevenue;
    }

    public BigDecimal getYield(Money money, int totalRevenue) {
        return new BigDecimal(totalRevenue).divide(new BigDecimal(money.getMoney()), 2, BigDecimal.ROUND_HALF_UP);
    }
}

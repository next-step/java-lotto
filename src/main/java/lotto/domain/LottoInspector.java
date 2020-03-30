package lotto.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoInspector {
    private Lotto winningLotto;
    private List<Lotto> lottos;
    private Map<Integer, Integer> matchedResult;

    public LottoInspector(Lotto winningLotto, List<Lotto> lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        checkLottos();
    }

    public Map<Integer, Integer> getMatchedResult() {
        return this.matchedResult;
    }

    public int getTotalRevenue() {
        int totalRevenue = 0;
        for (Integer key : matchedResult.keySet()) {
            totalRevenue += calculateReward(key, matchedResult.get(key));
        }
        return totalRevenue;
    }

    public BigDecimal getYield(Money money, int totalRevenue) {
        return new BigDecimal(totalRevenue).divide(new BigDecimal(money.getMoney()), 2, BigDecimal.ROUND_HALF_UP);
    }

    private int calculateReward(int matched, int count) {
        if (RewardEnum.isWinning(matched)) {
            return RewardEnum.getRewardFromMatched(matched) * count;
        }
        return 0;
    }

    private void checkLottos() {
        this.matchedResult = new LinkedHashMap<>();
        for (Lotto lotto : lottos) {
            putMatchedResult(winningLotto.getMatchedCount(lotto));
        }
    }

    private void putMatchedResult(Integer matchedName) {
        if (this.matchedResult.containsKey(matchedName)) {
            this.matchedResult.put(matchedName, this.matchedResult.get(matchedName) + 1);
        }
        this.matchedResult.put(matchedName, 1);
    }
}

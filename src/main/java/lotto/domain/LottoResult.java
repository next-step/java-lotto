package lotto.domain;

import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> resultMap;

    public LottoResult(Map<Rank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public static LottoResult calculateLottoResult(Lottos lotto, Lotto winLotto) {
        return new LottoResult(lotto.calculateResult(winLotto));
    }

    public double calculateWinMoney() {
        double getMoney = 0;
        for (Rank rank : Rank.values()) {
            getMoney += resultMap.get(rank) * rank.winMoney();
        }
        return getMoney;
    }

    public int getRankCount(Rank rank) {
        return resultMap.get(rank);
    }

}

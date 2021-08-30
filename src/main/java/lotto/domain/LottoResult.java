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

    public double calculateYeild() {
        double buyMoney = calculateBuyMoney();
        double getMoney = 0;
        for (Rank rank : Rank.values()) {
            getMoney += resultMap.get(rank) * rank.winMoney();
        }
        return getMoney / buyMoney;
    }

    private int calculateBuyMoney() {
        int buyLottoCount = 0;
        for (Rank rank : resultMap.keySet()) {
            buyLottoCount += resultMap.get(rank);
        }
        return buyLottoCount * Lotto.LOTTO_PRICE;
    }

    public int getRankCount(Rank rank) {
        return resultMap.get(rank);
    }

    public int first() {
        return resultMap.get(Rank.FIRST);
    }

    public int second() {
        return resultMap.get(Rank.SECOND);
    }

    public int third() {
        return resultMap.get(Rank.THIRD);
    }

    public int fourth() {
        return resultMap.get(Rank.FOURTH);
    }

    public int last() {
        return resultMap.get(Rank.LAST);
    }

}

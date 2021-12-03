package lotto.domain;

import lotto.view.InputInfo;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private Map<Integer, Integer> resultInfo;
    private double rateOfReturn;

    public Result(Lottos lottos, Lotto answer) {
        resultInfo = new HashMap<>();
        init();
        calculateResult(lottos, answer);
    }

    private void init() {
        for (Rank rank : Rank.values()) {
            resultInfo.put(rank.getCount(), 0);
        }
    }

    public void calculateResult(Lottos lottos, Lotto answer) {
        double revenue = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int count = answer.matchCount(lotto);
            revenue = getRevenue(revenue, count);
        }

        this.rateOfReturn = revenue / (lottos.getLottos().size() * InputInfo.LOTTO_PRICE);
    }

    private double getRevenue(double revenue, int count) {
        if (count >= Rank.TRIO.getCount()) {
            this.resultInfo.put(count, this.resultInfo.get(count) + 1);
            Rank rank = Rank.getRank(count);
            revenue += rank.getAmount();
            return revenue;
        }
        return revenue;
    }

    public Map<Integer, Integer> getResultInfo() {
        return resultInfo;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}

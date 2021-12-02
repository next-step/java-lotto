package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class ResultInfo {

    private Map<Integer, Integer> resultInfo;
    private double rateOfReturn;

    public ResultInfo(Lottos lottos, Lotto answer) {
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

        this.rateOfReturn = revenue / (lottos.getLottos().size() * InputInfo.TICKET_PRICE);
    }

    private double getRevenue(double revenue, int count) {
        if (count > 2) {
            this.resultInfo.put(count, this.resultInfo.get(count) + 1);
            Rank rank = Rank.getRank(count);
            revenue += rank != null ? rank.getAmount() : 0;
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

package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> resultInfo;
    private double rateOfReturn;

    public Result(Lottos lottos, Lotto answer, Bonus bonus) {
        resultInfo = new HashMap<>();
        init();
        calculateResult(lottos, answer, bonus);
    }

    private void init() {
        for (Rank rank : Rank.values()) {
            resultInfo.put(rank, 0);
        }
    }

    public void calculateResult(Lottos lottos, Lotto answer, Bonus bonus) {
        double revenue = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int count = answer.matchCount(lotto);
            boolean isBonus = lotto.getNumbers().contains(bonus.getNumber());
            revenue = getRevenue(revenue, count, isBonus);
        }
        this.rateOfReturn = revenue / (lottos.getLottos().size() * Lottos.LOTTO_PRICE);
    }

    private double getRevenue(double revenue, int count, boolean isBonus) {
        if (count >= Rank.FIFTH.getCount()) {
            Rank rank = Rank.getRank(count, isBonus);
            this.resultInfo.put(rank, this.resultInfo.get(rank) + 1);
            revenue += rank.getAmount();
            return revenue;
        }
        return revenue;
    }

    public Map<Rank, Integer> getResultInfo() {
        return resultInfo;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}

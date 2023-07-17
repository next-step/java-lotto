package lotto.domain.statistics;

import java.util.Map;
import lotto.domain.game.Payment;

public class ProfitRate {

    private final double profitRate;

    public ProfitRate(final Payment payment, final Map<LottoMatch, Integer> resultMap) {
        this.profitRate = calculateProfitRate(payment, resultMap);
    }

    private double calculateProfitRate(final Payment payment, final Map<LottoMatch, Integer> resultMap) {
        double profit = 0;
        for (LottoMatch lottoMatch : resultMap.keySet()) {
            profit += (double) resultMap.get(lottoMatch) * lottoMatch.getPrize();
        }
        return payment.calculateProfitRate(profit);
    }

    public double getProfitRate() {
        return profitRate;
    }

}

package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class LottoStatistic {

    private final Map<LottoRank, Integer> statistic;
    private double profit = Double.NaN;
    private String profitText = "손해";

    public LottoStatistic(Map<LottoRank, Integer> statistic) {
        this.statistic = statistic;
    }

    public double calculateProfit(int amount) {
        BigDecimal purchaseAmount = new BigDecimal(amount);
        BigDecimal prizeAmount = new BigDecimal(0);
        for (LottoRank rank : statistic.keySet()) {
            prizeAmount = prizeAmount.add(new BigDecimal(rank.getPrize() * statistic.get(rank)));
        }
        this.profit = prizeAmount.divide(purchaseAmount, 2, BigDecimal.ROUND_DOWN).doubleValue();
        if (profit > 1) {
            this.profitText = "이익이";
        }
        return profit;
    }

    public void print() {
        for (LottoRank rank : statistic.keySet()) {
            System.out.printf("%d개 일치 (%d) - %d개%n", rank.getMatchingCount(), rank.getPrize(), statistic.get(rank));
        }
        System.out.printf("총 수익률은 %1.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)%n", profit, profitText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoStatistic that = (LottoStatistic) o;

        return Objects.equals(statistic, that.statistic);
    }

    @Override
    public int hashCode() {
        return statistic != null ? statistic.hashCode() : 0;
    }

}

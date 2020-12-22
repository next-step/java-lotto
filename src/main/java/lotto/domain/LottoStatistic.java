package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class LottoStatistic {

    private static final int DIVIDE_SCALE = 2;
    private final Map<LottoRank, Integer> statistic;

    public LottoStatistic(Map<LottoRank, Integer> statistic) {
        this.statistic = statistic;
    }

    private int sumPrizeAmount() {
        int sum = 0;
        for (LottoRank rank : statistic.keySet()) {
            sum += rank.getPrize() * statistic.get(rank);
        }
        return sum;
    }

    public double calculateProfit(int amount) {
        BigDecimal total = new BigDecimal(sumPrizeAmount());
        BigDecimal purchase = new BigDecimal(amount);
        return total.divide(purchase, DIVIDE_SCALE, BigDecimal.ROUND_DOWN).doubleValue();
    }

    public void print() {
        for (LottoRank rank : statistic.keySet()) {
            System.out.printf("%d개 일치 (%d) - %d개%n",
                    rank.getMatchingCount(),
                    rank.getPrize(),
                    statistic.get(rank));
        }
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

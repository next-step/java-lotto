package lotto.domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoStatistic {

    private static final int DIVIDE_SCALE = 2;
    private final SortedMap<LottoRank, Integer> statistic;

    public LottoStatistic(SortedMap<LottoRank, Integer> statistic) {
        this.statistic = statistic;
    }

    public double calculateProfit(long amount) {
        BigDecimal total = new BigDecimal(sumPrizeAmount());
        BigDecimal purchase = new BigDecimal(amount);
        return total.divide(purchase, DIVIDE_SCALE, BigDecimal.ROUND_DOWN).doubleValue();
    }

    private long sumPrizeAmount() {
        long sum = 0L;
        for (LottoRank rank : statistic.keySet()) {
            sum += rank.getPrize() * statistic.get(rank);
        }
        return sum;
    }

    public List<String> toFormattingStringList() {
        List<String> formattingString = new ArrayList<>();
        for (LottoRank rank : statistic.keySet()) {
            formattingString.add(String.format("%d개 일치 %s(%d) - %d개",
                    rank.getMatchingCount(), rank.getComment(), rank.getPrize(), statistic.get(rank)));
        }
        return formattingString;
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

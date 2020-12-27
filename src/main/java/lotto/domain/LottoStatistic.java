package lotto.domain;

import java.math.BigDecimal;
import java.util.*;

public class LottoStatistic {

    private static final int DIVIDE_SCALE = 2;
    private final SortedMap<LottoRank, Integer> statistic;

    public LottoStatistic() {
        statistic = new TreeMap<>();
    }

    public LottoStatistic(SortedMap<LottoRank, Integer> statistic) {
        this.statistic = Collections.unmodifiableSortedMap(statistic);
    }

    /**
     * 당청 통계에 로또 순위와 갯수 넣기
     * @param rank 로또 순위
     */
    public void putLottoStatisticMap(LottoRank rank) {
        if (rank.equals(LottoRank.MISS))
            return;
        if (statistic.containsKey(rank)) {
            statistic.put(rank, statistic.get(rank) + 1);
            return;
        }
        statistic.put(rank, 1);
    }

    /**
     * 로또 수익률 계산
     * @param amount 구매 금액
     * @return 로또 수익률
     */
    public double calculateProfit(long amount) {
        BigDecimal total = new BigDecimal(sumPrizeAmount());
        BigDecimal purchase = new BigDecimal(amount);
        return total.divide(purchase, DIVIDE_SCALE, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 출력용
     * @return 출력용 문자열
     */
    public List<String> toFormattingStringList() {
        List<String> formattingString = new ArrayList<>();
        for (LottoRank rank : statistic.keySet()) {
            formattingString.add(String.format("%d개 일치 %s(%d) - %d개",
                    rank.getMatchingCount(), rank.getComment(), rank.getPrize(), statistic.get(rank)));
        }
        return formattingString;
    }

    /**
     * 당첨금 합계 구하기
     * @return 당첨금 합계
     */
    private long sumPrizeAmount() {
        long sum = 0L;
        for (LottoRank rank : statistic.keySet()) {
            sum += rank.getPrize() * statistic.get(rank);
        }
        return sum;
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

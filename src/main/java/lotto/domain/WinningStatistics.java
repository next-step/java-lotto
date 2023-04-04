package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGame.LOTTO_PRICE;

public class WinningStatistics {
    private final Map<WinningGrade, Integer> lotteryStatistics;

    public WinningStatistics(Map<WinningGrade, Integer> lotteryStatistics) {
        this.lotteryStatistics = lotteryStatistics;
    }

    public int getWinningNumbers(WinningGrade winningGrade) {
        return lotteryStatistics.get(winningGrade);
    }

    @Override
    public String toString() {
        return lotteryStatistics.toString();
    }

    public Double getTotalRateOfReturn() {
        Long totalSum = lotteryStatistics.keySet().stream()
                .map(key -> lotteryStatistics.get(key) * key.getPrizeMoney())
                .reduce(0L, Long::sum);

        Integer totalCount = lotteryStatistics.keySet().stream().map(lotteryStatistics::get).reduce(0, Integer::sum);

        double returnRete = (double) totalSum / (LOTTO_PRICE.multiply(totalCount).toLong());
        return Math.round(returnRete * 1000) / 1000.0;
    }

    public int statisticsCount(WinningGrade grade) {
        return lotteryStatistics.get(grade);
    }

}

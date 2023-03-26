package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGame.LOTTO_PRICE;

public class WinningStatistics {
    private final Map<WinningGrade, Integer> lotteryStatistics;

    public WinningStatistics(WinningNumbers winningNumbers, List<Lotto> lottos) {
        Map<WinningGrade, Integer> lotteryStatistics = initStatistics();
        lottos.forEach(lotto -> {
            WinningGrade winningGrade = winningNumbers.getWinningGrade(lotto);
            lotteryStatistics.put(winningGrade, lotteryStatistics.get(winningGrade) + 1);
        });

        this.lotteryStatistics = Collections.unmodifiableMap(lotteryStatistics);
    }

    private Map<WinningGrade, Integer> initStatistics() {
        Map<WinningGrade, Integer> lotteryStatistics = new HashMap<>();
        for (WinningGrade grade : WinningGrade.values()) {
            lotteryStatistics.put(grade, 0);
        }
        return lotteryStatistics;
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

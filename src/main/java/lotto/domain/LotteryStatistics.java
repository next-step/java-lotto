package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoGame.PRICE;

public class LotteryStatistics {
    private final Map<WinningGrade, Integer> lotteryStatistics;

    public LotteryStatistics() {
        this.lotteryStatistics = new HashMap<>();
    }

    public void add(WinningGrade winningGrade) {
        Integer count = lotteryStatistics.getOrDefault(winningGrade, 0);
        lotteryStatistics.put(winningGrade, ++count);
    }

    public int getWinningNumbers(WinningGrade winningGrade) {
        return lotteryStatistics.get(winningGrade);
    }

    @Override
    public String toString() {
        return lotteryStatistics.toString();
    }

    public double getTotalRateOfReturn() {
        Integer returnSum = lotteryStatistics.keySet().stream()
                .map(key -> lotteryStatistics.get(key) * key.getPrizeMoney())
                .reduce(0, Integer::sum);

        Integer count = lotteryStatistics.keySet().stream().map(lotteryStatistics::get).reduce(0, Integer::sum);
        return (double) returnSum / (PRICE * count);

    }
}

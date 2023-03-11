package lotto.domain;

import java.util.HashMap;
import java.util.Map;

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
}

package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoResults {

    private final List<Integer> winningNumberCounts;

    public LottoResults(List<Integer> winningNumberCounts) {
        this.winningNumberCounts = winningNumberCounts;
    }

    public int calculateWinningNumbersCount(int winningCount) {
        return (int) winningNumberCounts.stream()
                .filter(winningNumberCount -> winningNumberCount == winningCount)
                .count();
    }

    public int calculateTotalWinnings() {
        return IntStream.rangeClosed(LottoConfig.WINNING_COUNT_FROM, LottoConfig.WINNING_COUNT_TO)
                .mapToObj(winningCount -> Winnings.calculateWinnings(winningCount) * calculateWinningNumbersCount(winningCount))
                .reduce(0, Integer::sum);
    }

    public Map<Integer, Integer> calculateWinningCountStatistics() {
        Map<Integer, Integer> result = new HashMap<>();
        IntStream.rangeClosed(LottoConfig.WINNING_COUNT_FROM, LottoConfig.WINNING_COUNT_TO)
                .forEach(winningCount -> result.put(winningCount, calculateWinningNumbersCount(winningCount)));
        return result;
    }

    public double calculateYield(Money money) {
        return money.calculateYelid(calculateTotalWinnings());
    }

}

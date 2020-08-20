package step2.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoResults {

    private List<Integer> winningNumberCounts;

    public LottoResults(List<Integer> winningNumberCounts) {
        this.winningNumberCounts = winningNumberCounts;
    }

    public int calculateWinningNumbersCount(int winningCount) {
        return (int) winningNumberCounts.stream()
                .filter(winningNumberCount -> winningNumberCount == winningCount)
                .count();
    }

    public int calculateWinnings() {
        return IntStream.range(3, 7)
                .mapToObj(winningCount -> Winnings.calculateWinnings(winningCount) * calculateWinningNumbersCount(winningCount))
                .reduce(0, Integer::sum);
    }

}

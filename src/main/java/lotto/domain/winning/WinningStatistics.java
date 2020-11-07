package lotto.domain.winning;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningStatistics {

    private final Map<Integer, Integer> statistics;

    private WinningStatistics(Map<Integer, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics zero() {
        return new WinningStatistics(getZeroStatistics());
    }

    private static Map<Integer, Integer> getZeroStatistics() {
        return WinningReward.winningCountStream()
                .collect(Collectors.toMap(Function.identity(), winningCount -> 0));
    }

    public static WinningStatistics of(Map<Integer, Integer> statistics) {
        return new WinningStatistics(WinningReward.winningCountStream()
                .collect(Collectors.toMap(Function.identity(), getWinningLottoCount(statistics))));
    }

    private static Function<Integer, Integer> getWinningLottoCount(Map<Integer, Integer> statistics) {
        return winningCount -> {
            if (statistics.containsKey(winningCount)) {
                return statistics.get(winningCount);
            }
            return 0;
        };
    }

    public int getWinningLottoCount(int winningCount) {
        if (WinningReward.hasWinningPrice(winningCount)) {
            return statistics.get(winningCount);
        }
        return 0;
    }

    public void increaseWinningLottoCount(int winningCount) {
        if (WinningReward.hasWinningPrice(winningCount)) {
            statistics.put(winningCount, getWinningLottoCount(winningCount) + 1);
        }
    }

    public int calculateRevenue() {
        return WinningReward.winningCountStream()
                .mapToInt(winningCount -> WinningReward.getWinningPrice(winningCount) * getWinningLottoCount(winningCount))
                .sum();
    }

}

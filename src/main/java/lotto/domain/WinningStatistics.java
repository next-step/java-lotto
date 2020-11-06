package lotto.domain;

import lotto.domain.exception.InvalidWinningCountException;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class WinningStatistics {

    private static final int MIN_WINNING_COUNT = 0;
    private static final int MAX_WINNING_COUNT = 6;
    private final Map<Integer, Integer> statistics;

    private WinningStatistics(Map<Integer, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics empty() {
        Map<Integer, Integer> statistics = new HashMap<>();
        for (int winningCount = 0; winningCount <= MAX_WINNING_COUNT; winningCount++) {
            statistics.put(winningCount, 0);
        }
        return new WinningStatistics(statistics);
    }

    public static WinningStatistics of(Map<Integer, Integer> statistics) {
        statistics.keySet()
                .forEach(WinningStatistics::validateWinningCount);
        return new WinningStatistics(statistics);
    }


    public int getWinningLottoCount(int winningCount) {
        validateWinningCount(winningCount);
        return statistics.get(winningCount);
    }

    private static void validateWinningCount(int winningCount) {
        if (winningCount < MIN_WINNING_COUNT || winningCount > MAX_WINNING_COUNT) {
            throw new InvalidWinningCountException();
        }
    }

    public void increaseWinningLottoCount(int winningCount) {
        validateWinningCount(winningCount);
        statistics.put(winningCount, getWinningLottoCount(winningCount) + 1);
    }

    public int calculateRevenue() {
        return IntStream.range(MIN_WINNING_COUNT, MAX_WINNING_COUNT + 1)
                .filter(WinningReward::hasWinningPrice)
                .map(WinningReward::getWinningPrice)
                .sum();
    }
}

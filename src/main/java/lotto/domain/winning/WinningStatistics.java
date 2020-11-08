package lotto.domain.winning;

import lotto.domain.lotto.Money;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.winning.WinningReward.ZERO;

public class WinningStatistics {

    private final Map<WinningReward, Integer> statistics;

    private WinningStatistics(Map<WinningReward, Integer> statistics) {
        this.statistics = statistics;
    }

    public static WinningStatistics zero() {
        return new WinningStatistics(getZeroStatistics());
    }

    private static Map<WinningReward, Integer> getZeroStatistics() {
        return WinningReward.valuesStreamWithoutZero()
                .collect(Collectors.toMap(Function.identity(), winningCount -> 0));
    }

    public static WinningStatistics of(Map<WinningReward, Integer> statistics) {
        return new WinningStatistics(WinningReward.valuesStreamWithoutZero()
                .collect(Collectors.toMap(Function.identity(), getWinningLottoCount(statistics))));
    }

    private static Function<WinningReward, Integer> getWinningLottoCount(Map<WinningReward, Integer> statistics) {
        return winningReward -> {
            if (statistics.containsKey(winningReward)) {
                return statistics.get(winningReward);
            }
            return 0;
        };
    }

    public int getWinningLottoCount(WinningReward winningReward) {
        if (winningReward.equals(ZERO)) {
            return 0;
        }
        return statistics.get(winningReward);
    }

    public void increaseWinningLottoCount(int winningCount, boolean matchBonusNumber) {
        WinningReward winningReward = WinningReward.valueOf(winningCount, matchBonusNumber);
        if (!winningReward.equals(ZERO)) {
            statistics.put(winningReward, getWinningLottoCount(winningReward) + 1);
        }
    }

    public int calculateRevenue() {
        return WinningReward.valuesStreamWithoutZero()
                .mapToInt(winningReward -> winningReward.getWinningPrice() * getWinningLottoCount(winningReward))
                .sum();
    }

    public double calculateYield(Money money) {
        return calculateRevenue() / (double) money.getAmount();
    }
}

package lotto.domain.winning;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Created By mand2 on 2020-11-20.
 */
public class WinningStatistics {

    private Map<WinningRank, Integer> stats;

    private WinningStatistics(TreeMap<WinningRank, Integer> stats) {
        this.stats = stats;
    }

    public static WinningStatistics from(Map<WinningRank, Long> beforeStats) {
        TreeMap<WinningRank, Integer> stats = Arrays.stream(WinningRank.values())
                .collect(toMap(Function.identity(),
                        convertToIntFunction(beforeStats),
                        (count1, count2) -> count1,
                        TreeMap::new));

        return new WinningStatistics(stats);
    }

    private static Function<WinningRank, Integer> convertToIntFunction(Map<WinningRank, Long> beforeStats) {
        return winningRank -> Math.toIntExact(Optional.ofNullable(beforeStats.get(winningRank))
                                                    .orElse(0L));
    }

    private int sumWinningResult() {
        int result = 0;
        for (WinningRank winningRank : stats.keySet()) {
            result += winningRank.getPrize() * stats.get(winningRank);
        }

        return result;
    }

    public Map<WinningRank, Integer> stats() {
        return Collections.unmodifiableMap(this.stats);
    }

    public double earningRatio(int amount) {
        return sumWinningResult() / (double) amount;
    }


}

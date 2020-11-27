package lotto.domain.winning;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * Created By mand2 on 2020-11-20.
 */
public class WinningStatistics {

    private Map<WinningRank, Integer> stats;

    private WinningStatistics(Map<WinningRank, Integer> stats) {
        this.stats = new TreeMap<>(stats);
    }

    public static WinningStatistics from(Map<WinningRank, Long> beforeStats) {
        Map<WinningRank, Integer> stats = Arrays.stream(WinningRank.values())
                .collect(toMap(Function.identity()
                        , winningRank -> Math.toIntExact(
                                Optional.ofNullable(beforeStats.get(winningRank))
                                        .orElse(0L))));

        return new WinningStatistics(stats);
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

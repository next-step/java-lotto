package step3;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningStatistics {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    //    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private static final Map<Integer, WinningStatistics> matchedCounts =
            Collections.unmodifiableMap(Stream.of(values()).
                    collect(Collectors.toMap(WinningStatistics::getMatchedNumberCount, Function.identity())));

    private int matchedNumberCount;
    private int winningMoney;

    WinningStatistics(int matchedNumberCount, int winningMoney) {
        this.matchedNumberCount = matchedNumberCount;
        this.winningMoney = winningMoney;
    }

    public static WinningStatistics valueOfWinningCount(int winningCount) {
        return Optional.ofNullable(matchedCounts.get(winningCount)).orElse(MISS);
    }

    public static boolean matchedCount(int count) {
        return matchedCounts.containsKey(count);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

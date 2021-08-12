package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private static final int TOTAL_ZERO = 0;

    private final Map<MatchCount, Integer> winningLotteryCountMap;

    private MatchResult(Map<MatchCount, Integer> winningLotteryCountMap) {
        this.winningLotteryCountMap = Collections.unmodifiableMap(Objects.requireNonNull(winningLotteryCountMap));
    }

    public static MatchResult of(Map<MatchCount, Integer> matchesTotalMap) {
        return new MatchResult(matchesTotalMap);
    }

    public int countWinningLotteries(MatchCount matchCount) {
        return winningLotteryCountMap.getOrDefault(matchCount, TOTAL_ZERO);
    }
}

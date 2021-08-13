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

    public static MatchResult of(Map<MatchCount, Integer> winningLotteryCountMap) {
        return new MatchResult(winningLotteryCountMap);
    }

    public int countWinningLotteries(MatchCount matchCount) {
        return winningLotteryCountMap.getOrDefault(matchCount, TOTAL_ZERO);
    }

    public Money calculateTotalWinningAmount() {
        Money total = Money.zero();
        for (MatchCount matchCount : winningLotteryCountMap.keySet()) {
            int count = winningLotteryCountMap.get(matchCount);
            total = total.add(matchCount.calculateTotalWinningAmount(count));
        }
        return total;
    }
}

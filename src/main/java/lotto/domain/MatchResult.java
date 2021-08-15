package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class MatchResult {

    private static final int TOTAL_ZERO = 0;

    private final Map<Rank, Integer> winningLotteryCountMap;

    private MatchResult(Map<Rank, Integer> winningLotteryCountMap) {
        this.winningLotteryCountMap = Collections.unmodifiableMap(Objects.requireNonNull(winningLotteryCountMap));
    }

    public static MatchResult of(Map<Rank, Integer> winningLotteryCountMap) {
        return new MatchResult(winningLotteryCountMap);
    }

    public int countWinningLotteries(Rank rank) {
        return winningLotteryCountMap.getOrDefault(rank, TOTAL_ZERO);
    }

    public Money calculateTotalWinningAmount() {
        Money total = Money.zero();
        for (Rank rank : winningLotteryCountMap.keySet()) {
            int count = winningLotteryCountMap.get(rank);
            Money winningMoney = rank.getWinningMoney();
            total = total.add(winningMoney.multiply(count));
        }
        return total;
    }
}

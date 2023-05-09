package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoResults {

    private final Money spentMoney;
    private final Map<Rank, Integer> winningStats;

    public LottoResults(Money spentMoney, Map<Rank, Integer> winningStats) {
        this.spentMoney = spentMoney;
        this.winningStats = Collections.unmodifiableMap(winningStats);
    }

    public double winningRatio() {
        int totalReward = summingRewards();
        return spentMoney.ratio(totalReward);
    }

    private int summingRewards() {
        return winningStats.keySet().stream()
                .mapToInt(this::ranksTotalReward)
                .sum();
    }

    private int ranksTotalReward(Rank rank) {
        return winningStats.get(rank) * rank.reward();
    }
}

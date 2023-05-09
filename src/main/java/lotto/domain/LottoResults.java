package lotto.domain;

import java.util.Arrays;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Rank.values()).forEach(rank ->
                sb.append(rank).append(String.format("- %d개\n", winningStats.getOrDefault(rank, 0)))
        );
        return sb.toString();
    }
}

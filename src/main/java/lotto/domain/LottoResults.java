package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class LottoResults {

    private final Map<Rank, Integer> winningStats;

    public LottoResults(Map<Rank, Integer> winningStats) {
        this.winningStats = Collections.unmodifiableMap(winningStats);
    }

    public double winningRatio(Money lottoPrice) {
        Money rewards = summingRewards();
        Money spentMoney = spentMoney(lottoPrice);
        return rewards.divide(spentMoney);
    }

    private Money summingRewards() {
        int totalReward = winningStats.keySet().stream()
                .mapToInt(this::ranksTotalReward)
                .sum();
        return new Money(totalReward);
    }

    private int ranksTotalReward(Rank rank) {
        return ranksTotalCount(rank) * rank.reward();
    }

    private int ranksTotalCount(Rank rank) {
        return winningStats.get(rank);
    }

    private Money spentMoney(Money lottoPrice) {
        int totalCount = totalCount();
        return lottoPrice.multiply(totalCount);
    }

    private int totalCount() {
        return winningStats.keySet().stream()
                .mapToInt(this::ranksTotalCount)
                .sum();
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

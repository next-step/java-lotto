package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rewards {
    private final Map<Reward, Integer> rewards;

    public Rewards(List<Reward> rewards) {
        validate(rewards);
        this.rewards = rewards.stream()
                .collect(Collectors.toUnmodifiableMap(reward -> reward, reward -> 1, Integer::sum));
    }

    private void validate(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("보상이 없습니다.");
        }
    }

    public int firstPrizeCount() {
        return rewards.getOrDefault(Reward.FIRST, 0);
    }

    public int secondPrizeCount() {
        return rewards.getOrDefault(Reward.SECOND, 0);
    }

    public int thirdPrizeCount() {
        return rewards.getOrDefault(Reward.THIRD, 0);
    }

    public int fourthPrizeCount() {
        return rewards.getOrDefault(Reward.FOURTH, 0);
    }

    public float winningRate() {
        int totalPrize = rewards.entrySet().stream()
                .filter(it -> it.getValue() > 0 && it.getKey() != Reward.NONE)
                .mapToInt(it -> it.getKey().prize() * it.getValue())
                .sum();
        return (float) totalPrize / totalCost();
    }

    private int totalCost() {
        return rewards.values().stream()
                .mapToInt(it -> it * Money.UNIT)
                .sum();
    }
}

package lotto.domain;

import java.util.Map;

public class Rewards {
    private final Map<Reward, Integer> rewards;

    public Rewards(Map<Reward, Integer> rewards) {
        validate(rewards);
        this.rewards = rewards;
    }

    private void validate(Map<Reward, Integer> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("보상이 없습니다.");
        }
    }

    public int prizeCount(Reward reward) {
        return rewards.getOrDefault(reward, 0);
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

package lotto.domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validate(rewards);
        this.rewards = rewards;
    }

    private void validate(List<Reward> rewards) {
        if (rewards == null || rewards.isEmpty()) {
            throw new IllegalArgumentException("보상이 없습니다.");
        }
    }

    public int firstPrizeCount() {
        return (int) rewards.stream()
                .filter(reward -> reward == Reward.FIRST)
                .count();
    }

    public int secondPrizeCount() {
        return (int) rewards.stream()
                .filter(reward -> reward == Reward.SECOND)
                .count();
    }

    public int thirdPrizeCount() {
        return (int) rewards.stream()
                .filter(reward -> reward == Reward.THIRD)
                .count();
    }

    public int fourthPrizeCount() {
        return (int) rewards.stream()
                .filter(reward -> reward == Reward.FOURTH)
                .count();
    }

    public float winningRate() {
        int totalPrize = rewards.stream()
                .mapToInt(Reward::prize)
                .sum();
        return (float) totalPrize / (rewards.size() * Money.UNIT);
    }
}

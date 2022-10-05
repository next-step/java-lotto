package lotto.domain;

public class Profit {
    private final double value;

    public Profit(Reward reward) {
        this.value = calculate(reward);
    }

    private double calculate(Reward reward) {
        if (reward.isNone()) {
            return reward.value();
        }

        return reward.value() / (Lotto.PRICE * (double) reward.numberOfReward());
    }

    public double value() {
        return value;
    }
}

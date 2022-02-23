package lotto.domain;

public class Reward {

    private final double value;

    public Reward(Rankings rankings, Price buyPrice) {
        this.value = rankings.countRewardRate(buyPrice);
    }

    public double getValue() {
        return value;
    }
}

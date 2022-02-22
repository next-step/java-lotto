package lotto.domain;

public class Reward {

    private final double value;

    public Reward(Rankings rankings, int buyPrice) {
        this.value = rankings.countRewardRate(buyPrice);
    }

    public double getValue() {
        return value;
    }
}

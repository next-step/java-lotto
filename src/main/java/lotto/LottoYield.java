package lotto;

public class LottoYield {
    private final double paymentAmount;
    private final double rewardAmount;

    public LottoYield(int paymentAmount, int rewardAmount) {
        this.paymentAmount = paymentAmount;
        this.rewardAmount = rewardAmount;
    }

    public double calculate() {
        return Math.floor((rewardAmount / paymentAmount) * 100) / 100;
    }
}

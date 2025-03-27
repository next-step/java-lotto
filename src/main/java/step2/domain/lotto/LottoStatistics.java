package step2.domain.lotto;

public class LottoStatistics {

    private final int purchasedAmount;

    public LottoStatistics(int purchasedAmount) {
        this.purchasedAmount = purchasedAmount;
    }

    public double getWinningRate(long winningAmount) {
        return (double) winningAmount / purchasedAmount;
    }
}

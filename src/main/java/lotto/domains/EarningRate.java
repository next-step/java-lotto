package lotto.domains;

public class EarningRate {

    private float earningRate;

    public EarningRate(Scores scores, Purchase purchase) {
        long totalPrizeMoney = scores.totalMoney();
        int payment = purchase.payment();

        this.earningRate = (float)(Math.floor(totalPrizeMoney / (float)payment * 100) / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%.2f", earningRate);
    }
}

package lotto.domains;

public class EarningRate {

    private float earningRate;

    public EarningRate(Scores scores, Tickets tickets) {
        long totalPrizeMoney = scores.totalMoney();
        int payment = tickets.payment();

        this.earningRate = (float)(Math.floor(totalPrizeMoney / (float)payment * 100) / 100.0);
    }

    @Override
    public String toString() {
        return String.format("%.2f", earningRate);
    }
}

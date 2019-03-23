package lotto;

public class EarningRate {

    private double rate;

    public EarningRate(int lottoMoney, long winningMoney) {
        this.rate = (double) winningMoney / lottoMoney;
    }

    @Override
    public String toString() {
        return String.format("%.2f", rate);
    }
}

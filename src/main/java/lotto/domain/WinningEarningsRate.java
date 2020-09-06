package lotto.domain;

public class WinningEarningsRate {
    private double earningsRate;

    public WinningEarningsRate(int money, double totalWinningMoney) {
        earningsRate = calculationEarningsRate(money, totalWinningMoney);
    }

    private double calculationEarningsRate(int money, double totalWinningMoney) {
        return Math.floor(totalWinningMoney / money * 100) / 100.0;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}

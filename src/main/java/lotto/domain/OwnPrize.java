package lotto.domain;

public class OwnPrize {
    private WinNumbersCount winNumbersCount;
    private double earningsRate;
    
    public OwnPrize(WinNumbersCount winNumbersCount, CashPayments cashPayments) {
        this.winNumbersCount = winNumbersCount;
    }
    
    public double getEarningsRate() {
        return earningsRate;
    }
}

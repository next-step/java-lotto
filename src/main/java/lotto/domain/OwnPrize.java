package lotto.domain;

public class OwnPrize {
    private WinNumbersCount winNumbersCount;
    private EarningsRate earningsRate;
    
    public OwnPrize(WinNumbersCount winNumbersCount, CashPayments cashPayments) {
        this.winNumbersCount = winNumbersCount;
    }
}

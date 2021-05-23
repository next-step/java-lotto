package step3.domain;

import step3.common.ErrorCode;
import step3.common.WinningType;

public class Money {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private long money;
    private double profit;

    public Money(long money) {
        if(money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MONEY_RANGE.getErrorMessage());
        }
        this.money = money;
    }

    public int countLottoTicket() {
        return (int)(this.money/LOTTO_TICKET_PRICE);
    }

    public double calculateProfit(WinningType[] winningTypes) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculate(this.money, winningTypes);
    }
}

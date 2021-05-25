package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.List;

public class Money {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private long money;

    public Money(long money) {
        if(money < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MONEY_RANGE.getErrorMessage());
        }
        this.money = money;
    }

    public int countLottoTicket() {
        return (int)(this.money/LOTTO_TICKET_PRICE);
    }

    public double calculateProfit(long prizeSum) {
        ProfitCalculator profitCalculator = new ProfitCalculator();
        return profitCalculator.calculate(this.money, prizeSum);
    }
}

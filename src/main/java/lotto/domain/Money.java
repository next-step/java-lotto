package lotto.domain;

import lotto.common.ErrorCode;

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
        return Math.floor(((double) prizeSum/money)*100)/100.0;
    }
}

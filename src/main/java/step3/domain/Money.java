package step3.domain;

import step3.common.ErrorCode;
import step3.common.WinningType;

public class Money {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private long money;
    private double profit;

    public Money(long money) {
        this.money = money;
    }

    public int countLottoTicket() {
        return 0;
    }

    public double calculateProfit(WinningType[] winningTypes) {
        return 0;
    }
}

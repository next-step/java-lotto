package lotto.domain;

import lotto.exception.IllegalMoneyNumberException;

public class Money {

    private static final int MONEY_UNIT = 1000;
    private static final int EXCHANGE = 0;
    private final long number;

    private Money(long number) {
        this.number = number;
    }

    public static Money of(long number) {
        if (!isValid(number)) {
            throw new IllegalMoneyNumberException(number);
        }
        return new Money(number);
    }

    public static int purchaseMoney(int ticketCount) {
        return ticketCount * MONEY_UNIT;
    }

    public long lottoTicketCount() {
        return number / MONEY_UNIT;
    }

    private static boolean isValid(long number) {
        return number > 0 && number % MONEY_UNIT == EXCHANGE;
    }
}

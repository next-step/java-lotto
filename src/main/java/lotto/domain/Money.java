package lotto.domain;

import lotto.exception.IllegalMoneyNumberException;

public class Money {

    private static final int MONEY_UNIT = 1000;
    private static final int EXCHANGE = 0;
    private final long number;

    private Money(long number) {
        validate(number);
        this.number = number;
    }

    public static Money of(long number) {
        return new Money(number);
    }

    public static int purchaseMoney(int ticketCount) {
        return ticketCount * MONEY_UNIT;
    }

    public static long lottoTicketCount(int money) {
        return money / MONEY_UNIT;
    }

    public long lottoTicketCount() {
        return number / MONEY_UNIT;
    }

    private static void validate(long number) {
        if (number < MONEY_UNIT || (number % MONEY_UNIT) != EXCHANGE) {
            throw new IllegalMoneyNumberException(number);
        }
    }
}

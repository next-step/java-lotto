package lotto_auto.model;

import lotto_auto.ErrorMessage;

public class LottoStore {

    public final static int LOTTO_TICKET_PRICE = 1000;

    public static LottoBundle sell(int money) {
        throwIfNegativeMoney(money);
        int ticketCount = money / LOTTO_TICKET_PRICE;
        return new LottoBundle(ticketCount, ticketCount * LOTTO_TICKET_PRICE);
    }

    private static void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MONEY);
        }
    }
}

package lotto_auto.model;

import lotto_auto.ErrorMessage;

public class LottoStore {

    public static LottoBundle sell(int money) {
        throwIfNegativeMoney(money);
        int ticketCount = money / LottoTicket.PRICE;
        return new LottoBundle(ticketCount);
    }

    private static void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MONEY);
        }
    }
}

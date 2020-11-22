package lotto_auto.model;

import lotto_auto.Constant;
import lotto_auto.ErrorMessage;

public class LottoStore {

    public static LottoBundle sell(int money) {
        throwIfNegativeMoney(money);
        return new LottoBundle(money / Constant.LOTTO_TICKET_PRICE);
    }

    private static void throwIfNegativeMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_MONEY);
        }
    }
}

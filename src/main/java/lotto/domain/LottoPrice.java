package lotto.domain;

import lotto.dto.PaymentMoney;
import lotto.exception.NotEnoughMoneyException;

public class LottoPrice {
    public static final int LOTTO_PRICE = 1_000;

    public static void isEnoughMoney(PaymentMoney paymentMoney) {
        if(LOTTO_PRICE > paymentMoney.getValue()) {
            throw new NotEnoughMoneyException();
        }
    }
}

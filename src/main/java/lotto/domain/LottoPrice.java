package lotto.domain;

import lotto.dto.PurchaseMoney;
import lotto.exception.NotEnoughMoneyException;

public class LottoPrice {
    private LottoPrice() {

    }

    public static final int LOTTO_PRICE = 1_000;

    public static void isEnoughMoney(PurchaseMoney purchaseMoney) {
        if (LOTTO_PRICE > purchaseMoney.getValue()) {
            throw new NotEnoughMoneyException();
        }
    }
}

package lotto;

import common.StringResources;

public class LottoInput {

    public static final int LOTTO_PRICE = 1000;
    private final int amountMoney;

    public LottoInput(int amountMoney) {

        if (amountMoney == 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }

        if (amountMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }

        this.amountMoney = amountMoney;

    }

    public int getAmountMoney() {
        return amountMoney;
    }
}

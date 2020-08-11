package lotto;

import common.StringResources;

public class LottoInput {

    private final int amountMoney;

    public LottoInput(int amountMoney) {

        if (amountMoney == 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }

        if (amountMoney % 1000 != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }

        this.amountMoney = amountMoney;

    }

    public int getAmountMoney() {
        return amountMoney;
    }
}

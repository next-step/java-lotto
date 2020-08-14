package lotto.ui;

import common.StringResources;

public class LottoInput {

    public static final int LOTTO_PRICE = 1000;
    private final int amountMoney;

    public LottoInput(int amountMoney) {

        ResultView.print(StringResources.MSG_BUY_MONEY);

        if (amountMoney == 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }

        if (amountMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }

        this.amountMoney = amountMoney;

        ResultView.print((amountMoney / 1000) + StringResources.MSG_BUY_QUANTITY);
    }

    public int getAmountMoney() {
        return amountMoney;
    }
}

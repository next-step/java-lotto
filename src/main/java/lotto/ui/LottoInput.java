package lotto.ui;

import common.StringResources;

public class LottoInput {

    public static final int LOTTO_PRICE = 1000;
    private final int money;

    public LottoInput(int money) {

        ResultView.print(StringResources.MSG_BUY_MONEY);

        if (money == 0) {
            throw new IllegalArgumentException(StringResources.ERR_MUST_BUY);
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_UNIT);
        }

        this.money = money;
        ResultView.print(String.valueOf(money));
    }

    public int getMoney() {
        return money;
    }
}

package lotto.model;

import lotto.model.constants.Dividend;

public class WinnerMoney {
    private WinnerMoney() {
    }

    public static long findWinnerMoney(Dividend dividend, int winCount) {
        return dividend.dividendAmount() * winCount;
    }
}

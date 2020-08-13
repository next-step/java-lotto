package domain;

import util.CalculatorUtil;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private final int buyAmount;

    public LottoGame(int buyPrice) {
        this.buyAmount = CalculatorUtil.divide(buyPrice, LOTTO_PRICE);
    }

    public int getBuyAmount() {
        return buyAmount;
    }
}

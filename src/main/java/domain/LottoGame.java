package domain;

import strategy.RandomLottoNumberGenerator;
import util.CalculatorUtil;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private final int buyAmount;

    public LottoGame(int buyPrice) {
        this.buyAmount = CalculatorUtil.divideWholeNumber(buyPrice, LOTTO_PRICE);
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public Lottos issue(RandomLottoNumberGenerator randomNumberGenerator) {
        return Lottos.of(buyAmount, randomNumberGenerator);
    }
}

package domain;

import exception.LottoGamePriceException;
import strategy.RandomLottoNumberGenerator;
import util.CalculatorUtil;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private final int buyAmount;

    private LottoGame(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public static LottoGame of(int buyPrice) {
        int buyAmount = CalculatorUtil.divideWholeNumber(buyPrice, LOTTO_PRICE);
        validate(buyAmount);

        return new LottoGame(buyAmount);
    }

    private static void validate(int buyAmount) {
        if(buyAmount < 1) {
            throw new LottoGamePriceException();
        }
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public Lottos issue(RandomLottoNumberGenerator randomNumberGenerator) {
        return Lottos.of(buyAmount, randomNumberGenerator);
    }
}

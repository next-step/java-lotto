package domain;

import exception.LottoGamePriceException;
import strategy.RandomLottoNumberGenerator;
import util.CalculatorUtil;

public class LottoGame {

    public static final int LOTTO_PRICE = 1_000;
    public static final String INVALID_MANUAL_COUNT_MESSAGE = "구입 금액이 부족합니다.";

    private final int autoCount;
    private final int passivityCount;

    private LottoGame(int autoCount, int passivityGameCount) {
        this.autoCount = autoCount;
        this.passivityCount = passivityGameCount;
    }

    public static LottoGame of(int buyPrice, int passivityCount) {
        int buyAmount = CalculatorUtil.divideWholeNumber(buyPrice, LOTTO_PRICE);
        validate(buyAmount, passivityCount);

        return new LottoGame(buyAmount - passivityCount, passivityCount);
    }

    private static void validate(int buyAmount, int manualCount) {
        if (buyAmount < 1) {
            throw new LottoGamePriceException();
        }

        if (buyAmount < manualCount) {
            throw new LottoGamePriceException(INVALID_MANUAL_COUNT_MESSAGE);
        }
    }

    public Lottos issue(RandomLottoNumberGenerator randomNumberGenerator) {
        return Lottos.of(autoCount, randomNumberGenerator);
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getPassivityCount() {
        return passivityCount;
    }
}

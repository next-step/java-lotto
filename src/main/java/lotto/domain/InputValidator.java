package lotto.domain;

import lotto.exception.ExceedLottoPurchaseException;
import lotto.exception.InsufficientPriceException;
import lotto.exception.LottoSizeException;
import lotto.exception.MisMatchPriceUnitException;

import static lotto.constant.Constant.LOTTO_PRICE;

public class InputValidator {

    private static final int MIN_PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final int ZERO = 0;

    private InputValidator() {
    }

    public static void validatePurchasePrice(int price) {
        validatePriceMinimumCondition(price);
        validatePriceUnitCondition(price);
    }

    private static void validatePriceMinimumCondition(int price) {
        if (price < MIN_PRICE) {
            throw new InsufficientPriceException();
        }
    }

    private static void validatePriceUnitCondition(int price) {
        if (price % LOTTO_PRICE != ZERO) {
            throw new MisMatchPriceUnitException();
        }
    }

    public static void validateLottoPurchaseAmount(int manualLottoCount, int price) {
        if (manualLottoCount * LOTTO_PRICE > price) {
            throw new ExceedLottoPurchaseException(manualLottoCount, price);
        }
    }

    public static void validateNumberCount(int size) {
        if (LOTTO_SIZE != size) {
            throw new LottoSizeException();
        }
    }

}

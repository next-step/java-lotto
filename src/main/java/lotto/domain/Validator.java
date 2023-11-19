package lotto.domain;

import lotto.exceptions.InvalidLottoAmountException;
import lotto.exceptions.InvalidLottoNumbersException;

import java.util.List;

public class Validator {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int NUMBERS_SIZE = 6;

    public static void validateAmount(int amount) {
        if (isInvalidAmount(amount) || isNegativeAmount(amount)) {
            throw new InvalidLottoAmountException(PRICE_OF_LOTTO, amount);
        }
    }

    private static boolean isInvalidAmount(int amount) {
        return amount % PRICE_OF_LOTTO != 0;
    }

    private static boolean isNegativeAmount(int amount) {
        return amount < 0;
    }

    public static void validateLottoNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBERS_SIZE) {
            throw new InvalidLottoNumbersException();
        }
    }
}

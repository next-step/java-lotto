package lotto.domain;

import lotto.exceptions.InvalidLottoAmountException;

public class Money {

    private static final int PRICE_OF_LOTTO = 1000;

    public static int calculateLottoQuantity(int purchaseAmount) {
        validateAmount(purchaseAmount);
        return purchaseAmount / PRICE_OF_LOTTO;
    }

    private static void validateAmount(int amount) {
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
}

package lotto.validate;

import static lotto.message.LottoErroMessage.*;

public class InputValidation {

    public static void inputValidate(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY.message());
        }
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_UNIT.message());
        }
    }

    public static void purchaseManualValidate(int manualCount, int lottoCount) {
        if (manualCount > lottoCount) {
            throw new IllegalArgumentException(OVER_INPUT_MANUAL_COUNT.message());
        }
    }
}

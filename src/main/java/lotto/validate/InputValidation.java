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
}

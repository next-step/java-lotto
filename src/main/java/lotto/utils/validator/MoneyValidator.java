package lotto.utils.validator;

import lotto.exception.BadMoneyException;

public class MoneyValidator {
    private MoneyValidator() {}

    public static void validateMoney(int money) {
        int zero = 0;
        if (money <= zero) {
            throw BadMoneyException.getInstance();
        }

    }

    public static void validateMoney(String money) {
        GeneralValidator.validateStrNum(money);
        int num = Integer.parseInt(money);
        validateMoney(num);
    }
}

package lotto.lib;

import lotto.exception.NegativeMoneyException;

public class MoneyValidator {
    private MoneyValidator() {}

    public static void validateMoney(int money) {
        int zero = 0;
        if (money <= zero) {
            throw NegativeMoneyException.getInstance();
        }

    }

    public static void validateMoney(String money) {
        GeneralValidator.validateStrNum(money);
        int num = Integer.parseInt(money);
        validateMoney(num);
    }
}

package lotto.util;

public class MoneyValidator extends Validator {

    private static final int MINIMUM_MONEY = 1000;

    private MoneyValidator() {
        super();
    }

    public static int validate(String input) {
        return validate( parseToInt(input));
    }

    public static int validate(int money) {
        validateMinimumMoney(money);
        return money;
    }

    private static void validateMinimumMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_MONEY + "원에 1장입니다. " + MINIMUM_MONEY + "보다 큰 값을 입력해주세요.");
        }
    }
}

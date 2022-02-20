package lotto.domain;

import lotto.util.Validator;

public class Money {

    private static final int MINIMUM_MONEY = 1000;

    private final int money;

    public Money(String input) {
        this.money = Validator.parseToInt(input);
        validateMinimumMoney(money);
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return money / MINIMUM_MONEY;
    }

    private static void validateMinimumMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_MONEY + "원에 1장입니다. " + MINIMUM_MONEY + "보다 큰 값을 입력해주세요.");
        }
    }
}

package lotto.validation;

import static lotto.model.Money.LOTTO_PER_MONEY;

public class MoneyValidator {

    public static void assertMoney(int money) {
        if (money < LOTTO_PER_MONEY) {
            throw new IllegalArgumentException(LOTTO_PER_MONEY + "원 이상의 금액을 입력해주세요");
        }
    }

}

package lotto.domain;

import lotto.constants.Constants;

public class Money {
    private static final int UNIT_CHECK_NUMBER = 0;

    private int money;

    private Money(final int amount) {
        this.money = amount;
    }

    public static Money from(final int amount) {
        validate(amount);
        return new Money(amount);
    }

    private static void validate(final int amount) {
        if (amount < Constants.LOTTO_PRICE) {
            throw new RuntimeException(String.format("최소 구입 가능한 금액은 %s원 입니다.", Constants.LOTTO_PRICE));
        }
        if (amount % Constants.LOTTO_PRICE != UNIT_CHECK_NUMBER) {
            throw new RuntimeException(String.format("%s원 단위로 구입할 수 있습니다.", Constants.LOTTO_PRICE));
        }
    }

    public void buyLotto() {
        this.money = money - Constants.LOTTO_PRICE;
    }

    public boolean isPossibleBuyLotto() {
        return money >= Constants.LOTTO_PRICE;
    }
}

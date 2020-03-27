package lotto.domain;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class Money {

    private Money() {
    }

    public static int validate(int money) {
        if (money < DEFAULT_GAME_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다");
        }
        return money;
    }
}

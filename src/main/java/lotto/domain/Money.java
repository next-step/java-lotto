package lotto.domain;

public class Money {

    private Money() {
    }

    public static int validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다");
        }
        return money;
    }
}

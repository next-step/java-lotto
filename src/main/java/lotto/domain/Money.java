package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = validate(money);
    }

    private int validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다");
        }
        return money;
    }
}

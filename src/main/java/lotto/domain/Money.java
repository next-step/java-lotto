package lotto.domain;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("돈은 천원단위로만 받을 수 있습니다.");
        }
    }
}

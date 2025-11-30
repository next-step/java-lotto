package lotto.domain;

public class Money {

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

}

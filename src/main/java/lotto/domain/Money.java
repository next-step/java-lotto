package lotto.domain;

public class Money {

    private final int money;

    Money(int input) {
        money = input;
    }

    public int getMoney() {
        return money;
    }

    public static Money of (int input) {
        return new Money(input);
    }
}

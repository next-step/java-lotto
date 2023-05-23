package lotto.domain;

public class Money {
    private final long money;

    public Money(long money) {
        checkValidation(money);
        this.money = money;
    }

    private static void checkValidation(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("Wrong money");
        }
    }

    public static Money from(String money) {
        return new Money(Long.parseLong(money));
    }

    public int calculateNumberOfPurchase(Money price) {
        return (int) (money / price.money);
    }
}

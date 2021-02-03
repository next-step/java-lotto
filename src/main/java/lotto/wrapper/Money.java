package lotto.wrapper;

public class Money {
    private static final Money LOTTO_PRICE = new Money(1000);

    private int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException();
        }
        this.money = money;
    }

    public static Money subManual(Money amount, Count lottosManual) {
        int amountManual = amount.getMoney() - lottosManual.getCount() * LOTTO_PRICE.getMoney();
        return new Money(amountManual);
    }

    public int getMoney() {
        return money;
    }
}

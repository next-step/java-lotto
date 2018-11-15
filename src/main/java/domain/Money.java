package domain;

public class Money {

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public static final int LOTTO_PRICE = 1_000;

    public static LottoAmount calculateAmount(Money money) {
        return new LottoAmount(money.getMoney() / LOTTO_PRICE);
    }

    public static boolean isMoneyPositive(Money money) {
        return money.getMoney() > 0;
    }
}

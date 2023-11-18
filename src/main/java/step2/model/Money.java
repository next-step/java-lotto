package step2.model;

public class Money {

    private static final int EACH_LOTTO_MONEY = 1000;
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int determineLottoPurchaseCount() {
        return money / EACH_LOTTO_MONEY;
    }
}

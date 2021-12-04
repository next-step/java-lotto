package lotto;

public class Money {

    private static final int DEFAULT_BUY_COUNT = 0;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int countCanBuy(int unitPrice) {
        if (unitPrice <= 0) {
            return DEFAULT_BUY_COUNT;
        }

        return money / unitPrice;
    }
}

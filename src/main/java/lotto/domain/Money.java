package lotto.domain;

public class Money {
    private final int money;

    Money(int money) {
        this.money = money;
    }

    public int buyableLottos(int price) {
        return money / price;
    }
}

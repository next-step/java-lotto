package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    public Money(String getMoney) {
        money = Integer.parseInt(getMoney);
    }

    public int divideToMoney() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}

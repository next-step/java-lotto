package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("0원 미만 금액 불가능");
        }
        this.money = money;
    }

    public int buyCount(int price) {
        return money / price;
    }

    public int getMoney() {
        return money;
    }

}

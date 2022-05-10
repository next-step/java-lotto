package lotto.domain;

public class Money {

    private final static String MIN_PURCHASE_AMOUNT_MESSAGE = "1000원 이상의 구매금액이 필요합니다.";
    private final static int MIN_PRICE = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < MIN_PRICE) {
            throw new IllegalStateException(MIN_PURCHASE_AMOUNT_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }
}

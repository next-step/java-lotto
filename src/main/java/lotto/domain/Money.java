package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money from(int money) {
        valid(money);
        return new Money(money);
    }

    private static void valid(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE + " 미만은 로또를 구매할 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }
}

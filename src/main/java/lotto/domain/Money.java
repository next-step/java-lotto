package lotto.domain;

public class Money {
    private static final int ONE_SALE_PRICE = 1000;
    private final int money;

    public Money(final int money) {
        validateMoney(money);
        this.money = money;
    }

    public int countLotto() {
        return money / ONE_SALE_PRICE;
    }

    private void validateMoney(final int money) {
        if (money < ONE_SALE_PRICE) {
            throw new IllegalArgumentException("로또를 구입할 수가 없습니다.");
        }
    }
}

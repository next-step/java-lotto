package lotto.domain;

public final class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final String INVALID_LOTTO_PRICE_MESSAGE = "로또를 구매하려면 최소 1000원 이상을 입력해야합니다.";
    private final int money;

    public Money(int money) {
        validatePrice(money);
        this.money = money;
    }

    private void validatePrice(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE_MESSAGE);
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }

}

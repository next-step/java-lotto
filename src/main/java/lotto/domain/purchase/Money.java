package lotto.domain.purchase;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String LOTTO_ERROR_MESSAGE = "돈이 부족합니다.";
    private final int money;

    public Money(int money) {
        this.money = parse(money);
    }

    private int parse(int money) {
        if (isValidate(money)) {
            throw new IllegalArgumentException(LOTTO_ERROR_MESSAGE);
        }
        return money;
    }

    public int purchaseLottoCount() {
        return money / LOTTO_PRICE;
    }

    private boolean isValidate(int money) {
        return money < LOTTO_PRICE;
    }
}

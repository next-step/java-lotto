package lotto.domain;

import static lotto.domain.LottoOptions.LOTTO_PRICE;

/**
 * 로또 구매할 돈
 */
public final class Money {
    private static final String INVALID_LOTTO_PRICE_MESSAGE = "로또를 구매하려면 최소 1000원 이상을 입력해야합니다.";
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

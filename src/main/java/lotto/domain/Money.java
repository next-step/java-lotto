package lotto.domain;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private static void validate(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("돈은 천원단위로만 받을 수 있습니다.");
        }
    }

    public Money buyManualLotto(int count) {
        if (money < count * LOTTO_PRICE) {
            throw new IllegalArgumentException("가진 돈보다 더 많은 수동 로또를 구매할 수 없습니다.");
        }
        return new Money(money - count * LOTTO_PRICE);
    }

    public int availableBuyLottoCount() {
        return money / LOTTO_PRICE;
    }
}

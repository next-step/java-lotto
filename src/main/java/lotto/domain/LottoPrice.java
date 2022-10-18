package lotto.domain;

import lotto.domain.exception.MoneyException;

public class LottoPrice {

    private final int price;

    public LottoPrice(int price) {
        this.price = price;
    }

    public LottoPrice() {
        this(1000);
    }

    public int lottoCount(int money) {
        validation(money);

        return money / price;
    }

    public int manualLottoCost(int money) {
        return money * price;
    }

    private void validation(int money) {
        if (money < 1000) {
            throw new MoneyException("1000원 이하로는 구매할 수 없습니다.");
        }
    }
}

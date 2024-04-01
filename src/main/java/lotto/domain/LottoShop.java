package lotto.domain;

import lotto.constant.Constants;

public class LottoShop {

    private int money;

    public LottoShop(final int money) {
        if (money % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해주세요.");
        }
        this.money = money;
    }

    public int calculatePurchaseCount() {
        return this.money / Constants.LOTTO_PRICE;
    }
}

package lotto.domain;

import lotto.constant.Constants;

public class LottoPurchase {
    public static int purchase(int money) {
        if (money % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매 금액은 1000원 단위로 입력해주세요.");
        }
        return money / Constants.LOTTO_PRICE;
    }
}

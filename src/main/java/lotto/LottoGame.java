package lotto;

import lotto.domain.Lotto;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static Lotto issueLotto(int price) {

        return new Lotto(price / LOTTO_PRICE);
    }
}

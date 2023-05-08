package lotto.domain;

import static lotto.constant.Constants.LOTTO_PRICE;

public class LottoCalculator {

    public static double rate(int amount, int quantity) {
        return ((double) amount / (LOTTO_PRICE * quantity));
    }
}

package lotto;

import lotto.domain.Money;

public class LottoService {
    public static int LOTTO_PRICE = 1000;

    public int purchase(Money money) {
        return money.divide(LOTTO_PRICE);
    }
}

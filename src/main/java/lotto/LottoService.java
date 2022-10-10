package lotto;

import lotto.domain.Money;

public class LottoService {
    public int purchase(Money money) {
        return money.divide(1000);
    }
}

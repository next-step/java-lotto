package step2.domain;

import java.math.BigDecimal;

public class LottoGame {

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private int count;

    public LottoGame(BigDecimal amount) {
        count = buyLotto(amount);
    }


    public int getCount() {
        return count;
    }

    private int buyLotto(BigDecimal amount) {
        return amount.divide(LOTTO_PRICE).intValue();
    }
}

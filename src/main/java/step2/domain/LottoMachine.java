package step2.domain;

import java.math.BigDecimal;

public class LottoMachine {

    private static final BigDecimal LOTTO_PRICE = BigDecimal.valueOf(1000);
    private final Lottos lottos = new Lottos();

    public Lottos createLotto(int money) {
        return lottos.createLottoList(getLottoCount(money));
    }

    public int getLottoCount(int money) {
        return BigDecimal.valueOf(money)
                .divide(LOTTO_PRICE)
                .intValue();
    }
}

package step2.domain;

import java.math.BigDecimal;

public class LottoStore {

    private static final BigDecimal PRICE_PER_SHEET = BigDecimal.valueOf(1000);

    public static int priceToNumberOfLotto(BigDecimal price) {
        return price.divide(PRICE_PER_SHEET).intValue();
    }

}

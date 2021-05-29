package lotto.domain.entity;

import java.math.BigDecimal;

public final class LottoPrice extends BigDecimal {

    public LottoPrice(String price) {
        super(price);
    }
}

package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.LottoPrice;

import java.math.BigDecimal;

public final class LottoStore {

    private final LottoPrice lottoPrice = new LottoPrice("1000");

    public LottoPrice price() {
        return lottoPrice;
    }

    public LottoList toSell(BigDecimal amountReceived) {
        BigDecimal purchaseCount = amountReceived.divide(price(), BigDecimal.ROUND_DOWN);
        return generateLotto(purchaseCount.intValue());
    }

    private LottoList generateLotto(int purchaseCount) {
        return new LottoList(purchaseCount);
    }

}

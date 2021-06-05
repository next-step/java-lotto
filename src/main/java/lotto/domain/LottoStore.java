package lotto.domain;

import lotto.domain.entity.LottoList;
import lotto.domain.entity.LottoPrice;

import java.math.BigDecimal;

public final class LottoStore {

    private final LottoPrice lottoPrice = new LottoPrice("1000");

    public LottoPrice price() {
        return lottoPrice;
    }

    public LottoList toSell(BigDecimal receivedAmount) {
        BigDecimal automaticLottoPurchaseCount = receivedAmount.divide(price(), BigDecimal.ROUND_DOWN);
        return generateLotto(automaticLottoPurchaseCount.intValue());
    }

    public LottoList toSell(BigDecimal receivedAmount, Lotto[] manualLottos) {
        receivedAmount = receivedAmount.subtract(lottoPrice.multiply(BigDecimal.valueOf(manualLottos.length)));
        validatePurchaseAmount(receivedAmount);
        BigDecimal automaticLottoPurchaseCount = receivedAmount.divide(price(), BigDecimal.ROUND_DOWN);
        return generateLotto(automaticLottoPurchaseCount.intValue(), manualLottos);
    }

    private void validatePurchaseAmount(BigDecimal receivedAmount) {
        if (receivedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }

    private LottoList generateLotto(int automaticLottoPurchaseCount) {
        return new LottoList(automaticLottoPurchaseCount);
    }

    private LottoList generateLotto(int automaticLottoPurchaseCount, Lotto[] manualLottos) {
        return new LottoList(automaticLottoPurchaseCount, manualLottos);
    }

}

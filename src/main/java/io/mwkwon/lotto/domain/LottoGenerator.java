package io.mwkwon.lotto.domain;

public interface LottoGenerator {
    BuyLottos createAutoLottos(LottoPayment lottoPayment);
}

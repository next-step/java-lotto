package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.BuyLottos;
import io.mwkwon.lotto.domain.LottoPayment;

public interface LottoGenerator {
    BuyLottos createAutoLottos(LottoPayment lottoPayment);
}

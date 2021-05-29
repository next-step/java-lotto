package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoNumber;
import io.mwkwon.lotto.domain.LottoPayment;
import io.mwkwon.lotto.domain.PurchaseQuantity;

public interface DataGenerator {
    LottoPayment requestInputPayment();
    Lotto requestWinningLottoNumbers();
    LottoNumber requestBonusBallNumber(Lotto winningLotto);
    PurchaseQuantity requestManualLottoPurchaseQuantity(LottoPayment lottoPayment);
}

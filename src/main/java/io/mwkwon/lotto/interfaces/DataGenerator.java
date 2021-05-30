package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.*;

import java.util.List;

public interface DataGenerator {
    LottoPayment requestInputPayment();
    Lotto requestWinningLottoNumbers();
    LottoNumber requestBonusBallNumber(Lotto winningLotto);
    PurchaseQuantity requestManualLottoPurchaseQuantity(LottoPayment lottoPayment);
    List<LottoNumbers> requestManualLottoNumbers(PurchaseQuantity purchaseQuantity);
}

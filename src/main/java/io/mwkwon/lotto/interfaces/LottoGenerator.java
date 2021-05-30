package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.BuyLottos;
import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoNumbers;
import io.mwkwon.lotto.domain.PurchaseQuantity;

public interface LottoGenerator {
    BuyLottos createAutoLottos(PurchaseQuantity purchaseQuantity);
    Lotto createManualLotto(LottoNumbers lottoNumbers);
}

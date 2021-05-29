package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.*;

import java.util.List;

public interface LottoGenerator {
    List<Lotto> createAutoLottos(PurchaseQuantity purchaseQuantity);
    Lotto createManualLotto(List<LottoNumber> lottoNumbers);
}

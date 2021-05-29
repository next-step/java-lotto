package io.mwkwon.lotto.interfaces;

import io.mwkwon.lotto.domain.BuyLottos;
import io.mwkwon.lotto.domain.Lotto;
import io.mwkwon.lotto.domain.LottoNumber;
import io.mwkwon.lotto.domain.LottoPayment;

import java.util.List;

public interface LottoGenerator {
    BuyLottos createAutoLottos(LottoPayment lottoPayment);
    Lotto createManualLotto(List<LottoNumber> lottoNumbers);
}

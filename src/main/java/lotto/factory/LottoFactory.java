package lotto.factory;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;

import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto manualCreateLotto(List<LottoNumbers> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto manualCreateSingleLotto(LottoNumbers lottoNumbers) {
        return new Lotto(Collections.singletonList(lottoNumbers));
    }
}
package lotto.application;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.money.LottoMoney;

import java.util.List;

public class LottoRequest {
    private final LottoMoney lottoMoney;
    private final List<LottoNumbers> lottoNumbers;

    public LottoRequest(LottoMoney lottoMoney, List<LottoNumbers> lottoNumbers) {
        this.lottoMoney = lottoMoney;
        this.lottoNumbers = lottoNumbers;
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }

}

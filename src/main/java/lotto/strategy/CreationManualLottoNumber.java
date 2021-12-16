package lotto.strategy;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class CreationManualLottoNumber implements CreationLottoNumber {

    @Override
    public Lotto lottoNumbers(String lottoNumbers) {
        return new Lotto(lottoNumbers);
    }
}

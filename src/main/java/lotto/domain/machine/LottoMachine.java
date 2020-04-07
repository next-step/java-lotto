package lotto.domain.machine;

import lotto.domain.lotto.Lottery;
import lotto.domain.lotto.LottoNumbers;

import java.util.List;

public class LottoMachine {

    public Lottery buy(LottoNumberStrategy lottoNumberStrategy) {
        List<LottoNumbers> lottoNumbers = lottoNumberStrategy.get();
        return Lottery.of(lottoNumbers);
    }
}

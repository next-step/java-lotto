package lotto.domain.machine;

import lotto.domain.lotto.Lotteries;

public class LottoMachine {

    public Lotteries buy(LottoNumberStrategy lottoNumberStrategy) {
        return lottoNumberStrategy.get();
    }
}

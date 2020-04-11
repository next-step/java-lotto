package lotto.domain.machine.infra;

import lotto.domain.lotto.Lotteries;
import lotto.domain.machine.LottoNumberStrategy;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {
    private final Lotteries lottoNumbers;

    public ManualLottoNumberStrategy(Lotteries lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Lotteries get() {
        return lottoNumbers;
    }
}

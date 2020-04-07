package lotto.domain.machine.infra;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.LottoNumberStrategy;

import java.util.List;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {
    private final List<LottoNumbers> lottoNumbers;

    public ManualLottoNumberStrategy(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumbers> get() {
        return lottoNumbers;
    }
}

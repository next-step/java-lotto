package lotto.infrastructure;

import lotto.domain.LottoNumberStrategy;
import lotto.domain.LottoNumbers;

import java.util.List;

public class ManualLottoNumberStrategy implements LottoNumberStrategy {
    private final List<LottoNumbers> lottoNumbers;

    public ManualLottoNumberStrategy(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public LottoNumbers get() {
        return null;
    }
}

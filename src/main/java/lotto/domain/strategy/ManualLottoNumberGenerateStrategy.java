package lotto.domain.strategy;

import lotto.domain.GenerateLottoNumberStrategy;
import lotto.domain.LottoAvailableNumber;

import java.util.List;

public class ManualLottoNumberGenerateStrategy implements GenerateLottoNumberStrategy {

    private final List<LottoAvailableNumber> lottoNumbers;

    public ManualLottoNumberGenerateStrategy(List<LottoAvailableNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoAvailableNumber> generate() {
        return lottoNumbers;
    }

}

package lotto.domain.strategy;

import lotto.domain.GenerateLottoNumberStrategy;

import java.util.List;

public class ManualLottoNumberGenerateStrategy implements GenerateLottoNumberStrategy {

    private final List<Integer> lottoNumbers;

    public ManualLottoNumberGenerateStrategy(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> generate() {
        return lottoNumbers;
    }

}

package lotto.generator;

import lotto.model.Lotto;

import java.util.List;

public class ManualLottoGeneratorStrategy implements LottoGeneratorStrategy {
    private final List<String> lottoNumbers;

    public ManualLottoGeneratorStrategy(List<String> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public Lotto lottoGenerator() {
        return Lotto.createLottoFrom(lottoNumbers);
    }
}

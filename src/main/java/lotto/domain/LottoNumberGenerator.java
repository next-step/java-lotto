package lotto.domain;

import java.util.Set;

public class LottoNumberGenerator {

    private final LottoNumberGenerateStrategy numberGenerateStrategy;

    public LottoNumberGenerator(LottoNumberGenerateStrategy numberGenerateStrategy) {
        this.numberGenerateStrategy = numberGenerateStrategy;
    }

    public Set<LottoNumber> generateLottoNumbers() {
        return numberGenerateStrategy.generateLottoNumbers();
    }
}

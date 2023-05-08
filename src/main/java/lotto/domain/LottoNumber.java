package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<LottoAvailableNumber> lottoNumbers;

    public LottoNumber(GenerateLottoNumberStrategy generateLottoNumberStrategy) {
        this.lottoNumbers = generateLottoNumberStrategy.generate();
    }

    public List<LottoAvailableNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}

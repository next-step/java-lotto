package lotto.model;

import java.util.List;

public final class FixLottoGenerator implements LottoGenerator {

    private final List<LottoNumber> lottoNumbers;

    public FixLottoGenerator(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumber> generate() {
        return this.lottoNumbers;
    }
}
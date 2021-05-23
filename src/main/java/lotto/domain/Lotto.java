package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }
}

package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public boolean equals(Lotto lotto) {
        return lottoNumbers.equals(lotto.getLottoNumbers());
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}

package io.mwkwon.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumber) {
        this.lottoNumbers = new ArrayList<>(lottoNumber);
    }

    public Lotto createLotto() {
        return Lotto.create(lottoNumbers);
    }

    public static LottoNumbers create(List<LottoNumber> lottoNumber) {
        return new LottoNumbers(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

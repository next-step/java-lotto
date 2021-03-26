package step2.domain.Lotto;

import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.Objects;

public final class Lotto {
    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static final Lotto newInstance(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
    }

    public final List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<LottoNumber> lottoNumber;

    public Lotto(List<LottoNumber> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<LottoNumber> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}

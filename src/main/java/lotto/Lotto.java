package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public Lotto(List<LottoNumber> numbers) {
        this.lottoNumbers = LottoNumbers.create(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

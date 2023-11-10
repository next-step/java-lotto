package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int DEFAULT_QUANTITY = 6;
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers =  new LottoNumbers(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
